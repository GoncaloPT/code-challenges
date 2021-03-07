package pt.goncalo.freeroam.nio2;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

/**
 * Lessons
 *  - Conflicting OpenOptions will throw an exception when specified together
 */
public class WriteToFile {

    public void addToFileWithConflitOptions(String content) throws IOException {
        Files.writeString(Path.of("test.txt"), content, StandardOpenOption.APPEND, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static void main(String[] args) throws IOException {
        new WriteToFile().addToFileWithConflitOptions("coasdsa");
    }
}
