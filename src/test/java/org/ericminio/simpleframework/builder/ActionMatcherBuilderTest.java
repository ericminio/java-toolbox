package org.ericminio.simpleframework.builder;

import org.ericminio.simpleframework.ActionMatcher;
import org.junit.Test;

import static org.ericminio.simpleframework.builder.ActionMatcherBuilder.anActionMatcher;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ActionMatcherBuilderTest {

    ActionMatcher matcher = anActionMatcher().withAction("action").andParameter( "param" ).build();
    
    @Test public void
    recordsTheGivenActionWithASlashPrefix() {
        assertThat(matcher.getAction(), equalTo("/action"));
    }
    
    @Test public void
    recordsTheParameter() {
        assertThat(matcher.getParameter(), equalTo("param"));
    }
}
