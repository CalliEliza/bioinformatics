package chapter1.readInFile;

import edu.duke.FileResource;
import edu.duke.URLResource;

/**
 * Created by callie on 8/13/16.
 */
public class ReadInFile {
    private FileResource input;
    private URLResource inputURL;

    public ReadInFile(FileResource input) {
        this.input = input;
    }

    public ReadInFile(URLResource inputURL) {
        this.inputURL = inputURL;
    }

    public String readInFile() {
        String file = input.asString();
        return file;
    }
    public String readInURL() {
        String file = inputURL.asString();
        return file;
    }
}
