package org.ericminio.simpleframework;

import com.gargoylesoftware.htmlunit.WebClient;
import org.junit.Test;

import java.io.IOException;

public class SimpleFrameworkServerTest {

    @Test public void
    portIs8090() throws IOException {
        SimpleFrameworkServer server = new SimpleFrameworkServer();
        server.start();
        WebClient browser = new WebClient();
        browser.getPage("http://localhost:8090/");
        server.stop();
    }
}
