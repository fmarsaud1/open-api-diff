package io.openapitools.openapi.diff;

import java.util.List;

import io.openapitools.openapi.diff.model.Endpoint;
import io.openapitools.openapi.diff.criteria.Diff;
import io.openapitools.openapi.diff.criteria.Maturity;
import io.openapitools.openapi.diff.compare.ResourceDiff;
import io.openapitools.openapi.diff.criteria.Versions;
import org.junit.Test;


import static org.junit.Assert.*;

public class APINoDiffTestIT {

    @Test
    public void testUnchangedAPI() {
        APIDiff api = new APIDiff("elaborate_example_v2d.json", "elaborate_example_v2e.json", Diff.ALL, Maturity.FULL, Versions.SINGLE);
        List<Endpoint> newEndpoints = api.getAddedEndpoints();
        List<Endpoint> missingEndpoints = api.getMissingEndpoints();
        List<ResourceDiff> changedEndPoints = api.getChangedResourceDiffs();
        assertTrue(newEndpoints.isEmpty());
        assertTrue(missingEndpoints.isEmpty());
        assertTrue(changedEndPoints.isEmpty());
    }
}
