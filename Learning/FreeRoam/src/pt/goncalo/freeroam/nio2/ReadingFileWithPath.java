package pt.goncalo.freeroam.nio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadingFileWithPath {


    public void readContentOfExistentFile() {

    }

    // this will throw NoSuchFileException
    public void readContentsOfMissingFile() {
        // parent folder and file don't exist
        Path p = Path.of("iDontExist/asd.txt");

        try (BufferedReader br = Files.newBufferedReader(p)) {
            br.lines().forEach(System.out::println);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void createFileInAbsentFolder() {
        Path p = Path.of("idontexist/log.txt");
        try {
            /**
             * This would work fine:
             * Files.createDirectories(p.getParent());
             * Files.createFile(p);
             **/
            //This will throw exceptionW
            Files.createFile(p);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static void main(String[] args) {
        var rfwp = new ReadingFileWithPath();
        rfwp.createFileInAbsentFolder();
    }
}
