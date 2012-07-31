package org.ericminio.simpleframework;

import org.simpleframework.http.Request;

public interface RequestMatcher {

    boolean matches(Request request);
}
