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

public class APISingleVersionSchemeTestIT {
    private final String REFERENCE_API = "elaborate_example_v2c.json";
    private final String SUBJECT_API = "elaborate_example_v2d.json";

   @Test
    public void testAPIChangesVersionSingleMaturityFullDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.FULL, Versions.SINGLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

    @Test
    public void testAPIChangesVersionSingleMaturityHALDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.HAL, Versions.SINGLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

    @Test
    public void testAPIChangesVersionSingleMaturityLowDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.LOW, Versions.SINGLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

    @Test
    public void testAPIChangesVersionSingleMaturityNoneDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.NONE, Versions.SINGLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

}