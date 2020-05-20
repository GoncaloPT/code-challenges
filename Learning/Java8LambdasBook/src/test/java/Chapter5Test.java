import chapter3.Chapter3;
import chapter5.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Chapter5Test {

    /**
     * Test for exercise 2a
     */
    @Test
    public void testCollector() {
        Stream<Chapter3.Artist> names = Stream.of("John Lennon", "Paul McCartney",
                "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe").map(Chapter3.Artist::new);

        Optional<Chapter3.Artist> artist = new Collectors().findArtistWithLongestName(names.collect(toList()));
        Assertions.assertEquals(artist.get().getName(), "Stuart Sutcliffe");
    }

    /**
     * Test for exercise 2b
     * Given a Stream where each element is a word, count the number of times each word appears.
     * So, if you were given the following input, you would return a Map of [John → 3, Paul → 2, George → 1]:
     *
     */
    @Test
    public void testCollectorB(){
        Stream<String> names = Stream.of("John", "Paul", "George", "John",
                "Paul", "John");
        Map<String, Long> mapa = new Collectors().countWordsInStream(names);
        Assertions.assertEquals(mapa.get("John"),3);
        Assertions.assertEquals(mapa.get("Paul"),2);
        Assertions.assertEquals(mapa.get("George"),1);
    }
}
