package org.ericminio.htmlunit;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;

import java.io.IOException;

public class WebFeatureDescriptionHelper {

    public WebClient browser = new WebClient();

    @After
    public void
    closeBrowser() throws IOException {
        browser.closeAllWindows();
    }

    protected HtmlPage currentPage() {
        return ((HtmlPage) browser.getCurrentWindow().getEnclosedPage());
    }

}