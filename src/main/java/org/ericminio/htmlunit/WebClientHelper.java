package org.ericminio.htmlunit;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebClientHelper {

    public static HtmlPage currentPage(WebClient browser) {
        return (HtmlPage) browser.getCurrentWindow().getEnclosedPage();
    }
}
