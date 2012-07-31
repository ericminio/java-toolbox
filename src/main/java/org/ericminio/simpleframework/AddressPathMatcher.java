package org.ericminio.simpleframework;

import org.simpleframework.http.Request;

public class AddressPathMatcher implements RequestMatcher {

    private String addressPath;

    public AddressPathMatcher(String addressPath) {
        this.addressPath = addressPath;
    }

    @Override
    public boolean matches(Request request) {
        return addressPath.equalsIgnoreCase(request.getAddress().getPath().getPath());
    }
}
