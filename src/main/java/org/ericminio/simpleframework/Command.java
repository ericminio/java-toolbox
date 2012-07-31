package org.ericminio.simpleframework;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;

import java.io.IOException;

public interface Command {

    void handle(Request request, Response response) throws IOException;
}
