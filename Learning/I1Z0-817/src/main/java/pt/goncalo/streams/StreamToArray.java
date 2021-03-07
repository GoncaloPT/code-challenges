package pt.goncalo.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToArray {

    /**
     * All valid ways of using Stream#toArray()
     */
    void toArrayVariancesOnStream(){
        Stream<String> a = Stream.of("a","b");
        //Object[] stream = a.toArray();
        String[] stream = a.toArray(String[]::new);
        //String[] stream = a.toArray(size -> new String[size]);



    }
}
