package io.openapitools.openapi.diff;

import java.util.List;
import java.util.Map;

import io.openapitools.openapi.diff.model.Endpoint;
import io.openapitools.openapi.diff.criteria.Diff;
import io.openapitools.openapi.diff.criteria.Maturity;
import io.openapitools.openapi.diff.compare.OperationDiff;
import io.openapitools.openapi.diff.compare.PropertyChanges;
import io.openapitools.openapi.diff.compare.ResourceDiff;
import io.openapitools.openapi.diff.criteria.Versions;
import io.swagger.models.HttpMethod;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class APINewResourceChangedPropertyDiffTestIT {
    private APIDiff api;

    @Before
    public void readSpecs() {
        api = new APIDiff("elaborate_example_v2e.json", "elaborate_example_v3e.json", Diff.ALL, Maturity.FULL, Versions.SINGLE);
    }

    @Test
    public void testMissingResource() {
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        assertTrue(!missingEndpoints.isEmpty());
        Endpoint endpoint = missingEndpoints.get(0);
        assertEquals("/account-events-new-resource", endpoint.getPathUrl());
    }

    @Test
    public void testAddedResource() {
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        assertTrue(!newEndpoints.isEmpty());
        assertEquals(1, newEndpoints.size());
        Endpoint endpoint = newEndpoints.get(0);
        assertEquals("/accounts/{regNo}-{accountNo}/cards", endpoint.getPathUrl());
        assertEquals(HttpMethod.GET, endpoint.getVerb());
        assertNull(endpoint.getOperation().getConsumes());
        assertEquals(2, endpoint.getOperation().getProduces().size());
        assertEquals("application/hal+json", endpoint.getOperation().getProduces().get(0));
        assertEquals("application/hal+json;concept=cards;v=1", endpoint.getOperation().getProduces().get(1));
        assertEquals(6, endpoint.getOperation().getParameters().size());
        assertEquals("Accept", endpoint.getOperation().getParameters().get(0).getName());

    }

    @Test
    public void testChangedProperty() {
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(1, changedEndPoints.size());
        assertNotNull(changedEndPoints.get(0));
        Map<HttpMethod, OperationDiff> changedOperations = changedEndPoints.get(0).getChangedOperations();
        assertEquals(1, changedOperations.size());
        OperationDiff theOperation = changedOperations.get(HttpMethod.PUT);
        assertNotNull(theOperation);
        assertNull(changedOperations.get(HttpMethod.GET));

        assertTrue(theOperation.getMissingProperties().isEmpty());
        assertTrue(theOperation.getAddedProperties().isEmpty());

        assertTrue(theOperation.getAddedParameters().isEmpty());
        assertTrue(theOperation.getMissingParameters().isEmpty());
        assertTrue(theOperation.getChangedParameters().isEmpty());

        assertTrue(theOperation.getAddedContentTypes().isEmpty());
        assertTrue(theOperation.getMissingContentTypes().isEmpty());

        assertTrue(theOperation.getAddedResponses().isEmpty());
        assertTrue(theOperation.getMissingResponses().isEmpty());
        assertTrue(theOperation.getChangedResponses().isEmpty());

        assertEquals(1, theOperation.getPotentiallyBreakingChanges().size());
        assertEquals(1, theOperation.getBreakingChanges().size());
        assertTrue(theOperation.getChanges().isEmpty());

        assertTrue(theOperation.getExistingCompliance().getChanges().isEmpty());

        List<PropertyChanges> changedProperties = theOperation.getChangedProperties();
        assertEquals(1, changedProperties.size());
        Map<String, List<String>> concretePropertyChanges = changedProperties.get(0).getChanges();
        assertTrue(concretePropertyChanges.containsKey("TransactionUpdate.body.currency"));
        assertNotNull(concretePropertyChanges.get("TransactionUpdate.body.currency"));
        assertEquals("body.property.changed.{body.currency.=[required.changed.from.false.to.true]}",
            concretePropertyChanges.get("TransactionUpdate.body.currency").get(0));
    }
}
