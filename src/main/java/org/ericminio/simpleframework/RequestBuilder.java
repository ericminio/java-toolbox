package org.ericminio.simpleframework;

import org.simpleframework.http.Address;
import org.simpleframework.http.Path;
import org.simpleframework.http.Request;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RequestBuilder {
    private String addressPath;

    private RequestBuilder() {
    }

    public static RequestBuilder aRequest() {
        return new RequestBuilder();
    }

    public RequestBuilder withAddressPath(String path) {
        this.addressPath = path;
        return this;
    }

    public Request build() {
        Request request = mock(Request.class);
        Address address = mock(Address.class);
        Path path = mock(Path.class);
        when(path.getPath()).thenReturn(addressPath);
        when(address.getPath()).thenReturn(path);
        when( request.getAddress() ).thenReturn(address);
        return request;
    }
}