package org.ericminio.simpleframework.builder;

import org.simpleframework.http.Response;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ResponseBuilder {
    private PrintStream output;

    private ResponseBuilder() {
    }

    public static ResponseBuilder aResponse() {
        return new ResponseBuilder();
    }

    public ResponseBuilder withPrintStream(PrintStream output) {
        this.output = output;
        return this;
    }

    public Response build() throws IOException {
        Response response = mock(Response.class);
        when(response.getPrintStream()).thenReturn(output);
        return response;
    }
}