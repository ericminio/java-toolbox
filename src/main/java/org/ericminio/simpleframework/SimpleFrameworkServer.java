package org.ericminio.simpleframework;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.transport.connect.SocketConnection;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleFrameworkServer implements Container {

    private int port;
    private SocketConnection connection;

    public SimpleFrameworkServer() {
        this.port = 8090;
    }

    public void start() throws IOException {
        connection = new SocketConnection( this );
        connection.connect( new InetSocketAddress( port ) );
    }

    public void stop() throws IOException {
        connection.close();
    }

    @Override
    public void handle(Request request, Response response) {
        try {
            response.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
