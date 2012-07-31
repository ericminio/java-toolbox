package org.ericminio.io;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class FileReaderHelperTest {

    @Test public void
    canReadTheContentOfAFile() throws IOException {
        assertThat( FileReaderHelper.contentOfFile( "src/test/resources/a-file" ),
                equalTo("this is a file that exists for test purpose"));
    }
}
