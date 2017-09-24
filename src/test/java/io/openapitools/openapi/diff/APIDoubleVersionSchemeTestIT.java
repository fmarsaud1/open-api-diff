package io.openapitools.openapi.diff;

import java.util.List;

import io.openapitools.openapi.diff.model.Endpoint;
import io.openapitools.openapi.diff.criteria.Diff;
import io.openapitools.openapi.diff.criteria.Maturity;
import io.openapitools.openapi.diff.compare.ResourceDiff;
import io.openapitools.openapi.diff.criteria.Versions;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class APIDoubleVersionSchemeTestIT {
    private final String REFERENCE_API = "elaborate_example_v2c.json";
    private final String SUBJECT_API = "elaborate_example_v2d.json";

    @Test
    public void testAPIChangesVersionDoubleMaturityFullDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.FULL, Versions.DOUBLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

    @Test
    public void testAPIChangesVersionDoubleMaturityHALDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.HAL, Versions.DOUBLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

    @Test
    public void testAPIChangesVersionDoubleMaturityHATEOASDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.HATEOAS, Versions.DOUBLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

    @Test
    public void testAPIChangesVersionDoubleMaturityNoneDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.NONE, Versions.DOUBLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

}