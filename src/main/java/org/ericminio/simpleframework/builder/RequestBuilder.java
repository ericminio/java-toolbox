package org.ericminio.simpleframework.builder;

import org.simpleframework.http.Address;
import org.simpleframework.http.Form;
import org.simpleframework.http.Path;
import org.simpleframework.http.Request;

import java.io.IOException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RequestBuilder {
    private String addressPath;
    private String key;
    private String value;

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

        Form form = mock(Form.class);
        if (key != null) {
            when(form.containsKey(key)).thenReturn(true);
            if (value != null) {
                when(form.get(key)).thenReturn(value);
            }
        } else {
            when(form.containsKey(anyString())).thenReturn(false);
        }
        try {
            when(request.getForm()).thenReturn( form );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return request;
    }

    public RequestBuilder withParameter(String key) {
        this.key = key;
        return this;
    }

    public RequestBuilder andValue(String value) {
        this.value = value;
        return this;
    }
}