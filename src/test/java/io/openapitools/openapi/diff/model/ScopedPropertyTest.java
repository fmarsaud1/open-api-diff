package io.openapitools.openapi.diff.model;

import io.openapitools.openapi.diff.model.ScopedProperty;
import io.swagger.models.properties.Property;
import io.swagger.models.properties.StringProperty;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class ScopedPropertyTest {

    @Test
    public void testPropertyInstantiation(){
        Property p = new StringProperty("format");
        ScopedProperty ep = new ScopedProperty("El", p);
        assertEquals("El", ep.getEl());
        assertEquals(p, ep.getProperty());
    }
}
