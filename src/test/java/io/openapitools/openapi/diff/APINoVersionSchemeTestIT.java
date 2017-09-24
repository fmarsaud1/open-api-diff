package io.openapitools.openapi.diff;

import java.util.List;

import io.openapitools.openapi.diff.criteria.Diff;
import io.openapitools.openapi.diff.criteria.Maturity;
import io.openapitools.openapi.diff.compare.ResourceDiff;
import io.openapitools.openapi.diff.criteria.Versions;
import io.openapitools.openapi.diff.model.Endpoint;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class APINoVersionSchemeTestIT {
    private final String REFERENCE_API = "elaborate_example_v2c.json";
    private final String SUBJECT_API = "elaborate_example_v2d.json";

    @Test
    public void testAPIChangesVersionNoneMaturityFullDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.FULL, Versions.NONE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

    @Test
    public void testAPIChangesVersionNoneMaturityHALDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.HAL, Versions.NONE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

    @Test
    public void testAPIChangesVersionNoneMaturityHATEOASDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.HATEOAS, Versions.NONE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

    @Test
    public void testAPIChangesVersionNoneMaturityLowDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.LOW, Versions.NONE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

    @Test
    public void testAPIChangesVersionNoneMaturityDNoneDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.NONE, Versions.NONE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

}