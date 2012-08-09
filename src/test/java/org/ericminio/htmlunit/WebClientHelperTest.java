package org.ericminio.htmlunit;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.ericminio.simpleframework.SimpleFrameworkServer;
import org.junit.Test;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;

import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class WebClientHelperTest {

    @Test public void
    canGetTheCurrentPage() throws IOException {
        SimpleFrameworkServer server = new SimpleFrameworkServer() {
            @Override
            public void handle(Request request, Response response) {
                try {
                    PrintStream output = response.getPrintStream();
                    output.println("<html> <body></body> </html>");
                    response.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }    
        };
        server.start();
        WebClient browser = new WebClient();
        HtmlPage homePage = browser.getPage("http://localhost:8090");
        assertThat(homePage, equalTo(WebClientHelper.currentPage(browser)));

        browser.closeAllWindows();
        server.stop();
    }
    

}
