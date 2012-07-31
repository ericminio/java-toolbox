package org.ericminio.simpleframework.builder;

import org.ericminio.simpleframework.ActionMatcher;

public class ActionMatcherBuilder {

    private ActionMatcher actionMatcher;

    private ActionMatcherBuilder() {
        actionMatcher = new ActionMatcher();
    }

    public static ActionMatcherBuilder anActionMatcher() {
        return new ActionMatcherBuilder();
    }

    public ActionMatcherBuilder withAction(String action) {
        actionMatcher.setAction( action );
        return this;
    }

    public ActionMatcherBuilder andParameter(String parameter) {
        actionMatcher.setParameter( parameter );
        return this;
    }

    public ActionMatcher build() {
        return actionMatcher;
    }
}
