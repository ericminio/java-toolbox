package org.ericminio.simpleframework;

import org.junit.Test;
import org.simpleframework.http.Request;

import static org.ericminio.simpleframework.RequestBuilder.aRequest;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class RequestBuilderTest {

    @Test public void
    canBeCustomizedWithAGivenAddressPath() {
        Request request = aRequest().withAddressPath("/").build();
        assertThat(request.getAddress().getPath().getPath(), equalTo("/"));
    }
}
