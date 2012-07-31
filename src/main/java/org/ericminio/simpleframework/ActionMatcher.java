package org.ericminio.simpleframework;

import org.simpleframework.http.Request;

import java.io.IOException;

public class ActionMatcher implements RequestMatcher {

    private String action;
    private String parameter;

    @Override
    public boolean matches(Request request) {
        if (!action.equalsIgnoreCase(request.getAddress().getPath().getPath())) {
            return false;
        }
        try {
            if (!request.getForm().containsKey(parameter)) {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void setAction(String action) {
        this.action = "/" + action;
    }

    public String getAction() {
        return action;
    }

    public void setParameter(String param) {
        this.parameter = param;
    }

    public String getParameter() {
        return parameter;
    }
}
