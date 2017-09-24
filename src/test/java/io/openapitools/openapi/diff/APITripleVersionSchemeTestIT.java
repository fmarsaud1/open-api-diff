package io.openapitools.openapi.diff;

import java.util.List;

import io.openapitools.openapi.diff.criteria.Diff;
import io.openapitools.openapi.diff.compare.ResourceDiff;
import io.openapitools.openapi.diff.model.Endpoint;
import io.openapitools.openapi.diff.criteria.Maturity;
import io.openapitools.openapi.diff.criteria.Versions;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class APITripleVersionSchemeTestIT {
    private final String REFERENCE_API = "elaborate_example_v2c.json";
    private final String SUBJECT_API = "elaborate_example_v2d.json";

    @Test
    public void testAPIChangesVersionTripleMaturityFullDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.FULL, Versions.TRIPLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

    @Test
    public void testAPIChangesVersionTripleMaturityHALDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.HAL, Versions.TRIPLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

    @Test
    public void testAPIChangesVersionTripleMaturityHATEOASDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.HATEOAS, Versions.TRIPLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

    @Test
    public void testAPIChangesVersionTripleMaturityLowDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.LOW, Versions.TRIPLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

    @Test
    public void testAPIChangesVersionTripleMaturityNoneDiffBreaking() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.BREAKING, Maturity.NONE, Versions.TRIPLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(changedEndPoints.isEmpty());
    }

    @Test
    public void testAPIChangesVersionTripleMaturityNoneDiffPotentiallyBreaking() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.POTENTIALLY_BREAKING, Maturity.NONE, Versions.TRIPLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(changedEndPoints.isEmpty());
    }

    @Test
    public void testAPIChangesVersionTripleMaturityNoneDiffLaissezFaire() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.LAISSEZ_FAIRE, Maturity.NONE, Versions.TRIPLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(changedEndPoints.isEmpty());
    }

    @Test
    public void testAPIChangesVersionTripleMaturityNoneDiffAll() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.ALL, Maturity.LOW, Versions.TRIPLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(!changedEndPoints.isEmpty());
        assertEquals(13, changedEndPoints.size());
    }

    @Test
    public void testAPIChangesVersionTripleMaturityLowDiffBreaking() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.BREAKING, Maturity.LOW, Versions.TRIPLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(changedEndPoints.isEmpty());
    }

    @Test
    public void testAPIChangesVersionTripleMaturityLowDiffPotentiallyBreaking() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.POTENTIALLY_BREAKING, Maturity.LOW, Versions.TRIPLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(changedEndPoints.isEmpty());
    }

    @Test
    public void testAPIChangesVersionTripleMaturityLowDiffLaissezFaire() {
        APIDiff api = new APIDiff(REFERENCE_API, SUBJECT_API, Diff.LAISSEZ_FAIRE, Maturity.LOW, Versions.TRIPLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(changedEndPoints.isEmpty());
    }

}