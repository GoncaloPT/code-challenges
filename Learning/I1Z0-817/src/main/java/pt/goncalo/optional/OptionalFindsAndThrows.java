package pt.goncalo.optional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalFindsAndThrows {

    static class Data{
        int number;

        public Data(int number) {
            this.number = number;
        }
    }

    /**
     * Doubt: what happens if you use findAny() then get()
     * from an empty Stream
     * <p>
     * Result: No such element exception
     */
    void emptyStreamGet() {
        Stream.empty().findAny().get();
    }

    /**
     * As it should already be clear from the above method,
     * calling get() in an empty optional wii throw {@link NoSuchElementException}
     */
    void getOnNullableOptional(){
        Optional.ofNullable(null).get();
    }

    void optionalOrElse() throws IOException {
        // amICalled is executed
        int value = Stream.of(0).findAny().orElse(amICalled());
        // amICalled is not executed
        int value2 = Stream.of(0).findAny().orElseGet(() -> {
            try {
                return amICalled();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return 0;
        });
    }

    static int i;
    private static Integer amICalled() throws IOException {
        System.out.println("I WAS CALLED!");
        Path root = Path.of("root");
        Long count = Files.find(root, 2, (p,a)-> true).count();
        return ++i;
    }

    /**
     * Is there a or method in Optional
     */
    void isThereAnOr(){

       // Stream.of("a","b").findFirst().or(() -> "c");
    }


    public static void main(String[] args) throws IOException {
        var ofat = new OptionalFindsAndThrows();
        //ofat.emptyStreamGet();
        //ofat.getOnNullableOptional();
        //ofat.optionalOrElse();
        //System.out.println(amICalled());

        String value = Stream.<String>empty().findAny().or(() -> Optional.of("")).orElseGet(() -> "another");
        Stream.of(1).reduce(Integer::sum);
        System.out.println("value is : " + value);



    }


}

