package org.ericminio.simpleframework;

import org.junit.Test;

import static org.ericminio.simpleframework.builder.RequestBuilder.aRequest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddressPathMatcherTest {

    RequestMatcher matcher = new AddressPathMatcher("/a/path");

    @Test public void
    matchesARequestWithAGivenAddressPath() {
        assertTrue(matcher.matches(aRequest().withAddressPath("/a/path").build()));
    }
    
    @Test public void
    caseInsensitive() {
        assertTrue(matcher.matches(aRequest().withAddressPath("/A/PATH").build()));
    }
    
    @Test public void
    dontMatchAnyOtherAddressPath() {
        assertFalse( matcher.matches( aRequest().withAddressPath( "another/path" ).build() ) );
    }
}
