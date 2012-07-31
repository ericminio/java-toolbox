package org.ericminio.simpleframework;

import org.junit.Test;

import static org.ericminio.simpleframework.builder.RequestBuilder.aRequest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ActionMatcherTest {

    @Test public void
    matchesARequestWithActionAndParameter() {
        ActionMatcher matcher = new ActionMatcher();
        matcher.setAction("my-action");
        matcher.setParameter( "param" );
        assertTrue(matcher.matches(aRequest().withAddressPath("/my-action")
                                             .withParameter("param").build()));
    }

    @Test public void
    dontMatchActionWithoutTheParameter() {
        ActionMatcher matcher = new ActionMatcher();
        matcher.setAction("my-action");
        matcher.setParameter( "param" );
        assertFalse( matcher.matches( aRequest().withAddressPath( "/my-action" ).build() ) );
    }

    @Test public void
    matchesARequestWithActionAndParameterAndValue() {
        ActionMatcher matcher = new ActionMatcher();
        matcher.setAction("my-action");
        matcher.setParameter("param");
        assertTrue(matcher.matches(aRequest().withAddressPath("/my-action")
                .withParameter("param")
                .andValue("value").build()));
    }
}
