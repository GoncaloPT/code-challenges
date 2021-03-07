package pt.goncalo.nio2;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardOpenOption.APPEND;

public class Tryouts {


    public static void main(String[] args) {
        new Tryouts().relativize();
        //Path path1 = Paths.get("log",".");
        //System.out.println("path1: " + path1.toString());
        // relative paths are never equal to absolute paths



    }

    void relativize(){
        Path path1 = Path.of("a/b");
        Path path2 = Path.of("a/c");
        System.out.println(path1.relativize(path2));
    }

    public void tryingWrite(String fileName, StandardOpenOption[] options) throws IOException {
        Path p = Path.of(fileName);
        // APPEND + TRUNCATE SHOULD THROW EXCEPTION
        Files.writeString(p,"append this", options);
    }

    public void tryToWriteWithReadOpenOption() throws IOException {
        Path p = Path.of("test2.txt");
        Files.writeString(p,"thisShouldThrow", StandardOpenOption.READ);
    }


}
