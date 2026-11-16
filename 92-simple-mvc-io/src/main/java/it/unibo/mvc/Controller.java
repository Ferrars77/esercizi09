package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String DEFAULT_TEXT = "output.txt";
    private static final String HOME_FOLDER = System.getProperty("user.home");
    private File currentFile = new File(HOME_FOLDER + File.separator + DEFAULT_TEXT);

    public File getCurrentFile() {
        return currentFile;
    }

    public String getPath(File current) {
        return currentFile.getPath();
    }

   public void setCurrentFile(File current) {
        if (current == null || current.getParent() == null) {
            throw new IllegalArgumentException("Cannot save in a null folder.");
        }
        this.currentFile = current;
    }

    public void printOnFile(String content) throws IOException {
        try (PrintStream ps = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            ps.println(content);
        }
    }
}
