package org.ericminio.simpleframework.builder;

import org.junit.Test;
import org.simpleframework.http.Request;

import java.io.IOException;

import static org.ericminio.simpleframework.builder.RequestBuilder.aRequest;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class RequestBuilderTest {

    @Test public void
    canBeCustomizedWithAGivenAddressPath() {
        Request request = aRequest().withAddressPath("/").build();
        assertThat(request.getAddress().getPath().getPath(), equalTo("/"));
    }
    
    @Test public void
    canBeCustomizedWithAGivenParameterAndItsValue() throws IOException {
        Request request = aRequest().withParameter( "param" ).andValue( "value" ).build();
        assertThat(request.getForm().get( "param" ), equalTo("value"));
    }
    
    @Test public void
    returnsAnEmptyFormByDefault() throws IOException {
        Request request = aRequest().withAddressPath("/").build();
        assertFalse(request.getForm().containsKey("any"));
    }
}
