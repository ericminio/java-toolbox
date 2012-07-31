package org.ericminio.simpleframework.builder;

import org.junit.Test;
import org.simpleframework.http.Response;

import java.io.IOException;
import java.io.PrintStream;

import static org.ericminio.simpleframework.builder.ResponseBuilder.aResponse;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ResponseBuilderTest {

    @Test public void
    canBeBuiltWithAGivenPrintStream() throws IOException {
        PrintStream printStream = mock(PrintStream.class);
        Response response = aResponse().withPrintStream(printStream).build();

        assertThat(response.getPrintStream(), equalTo(printStream));
    }
}
