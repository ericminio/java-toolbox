package org.ericminio.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileReaderHelper {

    public static String contentOfFile(String path) throws IOException {
        return FileUtils.readFileToString( new File( path ) );
    }
}
