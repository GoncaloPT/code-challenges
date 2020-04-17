package chapter3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Chapter3 {

    /**
     * Exercise 1.1
     *
     * @param numbers
     * @return
     */
    public int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (accumulator, x) -> accumulator + x);
    }

    /**
     * Exercise 1.2
     *
     * @param artists
     * @return
     */
    public List<String> getNamesAndPlaces(List<Artist> artists) {
        return artists.stream().map(artist -> artist.getName() + artist.getPlaceOfOrigin()).collect(toList());
    }

    /**
     * Exercise 1.3
     *
     * @param albums
     * @return
     */
    public List<Album> getAlbunsWithAtMostThreeTracks(List<Album> albums) {
        return albums.stream().filter(album -> album.getTracks().size() <= 3).collect(Collectors.toList());
    }

    /**
     * Iteration. Convert this code sample from using external iteration to internal iteration:
     * <p>
     * int totalMembers = 0;
     * for (Artist artist : artists) {
     * Stream<Artist> members = artist.getMembers();
     * totalMembers += members.count();
     * }
     */
    public long exercice2(List<Artist> artists) {
        return artists.stream().map(artist -> artist.getMembers().count())
                //.reduce(0L, (acc,value) -> acc + value);
                .reduce(0L, Long::sum);
    }

    //Count the number of lower case
    public long exercice6(String word) {
        return word.chars().filter(letter -> !Character.isUpperCase(letter)).count();
    }

    /**
     * Find the String with the largest number of lowercase letters from a List<String>.
     * You can return an Optional<String> to account for the empty list case.
     *
     * @param words
     * @return
     */
    private IntPredicate isLowerCaseLetter = letter -> Character.isLowerCase(letter);
    public Optional<String> exercise7(List<String> words) {
        return words.stream().max((string1, string2) -> string1.chars().filter(isLowerCaseLetter).count() > string2.chars().filter(isLowerCaseLetter).count() ? 1 : -1);
    }

    /**
     * Same as above but uses a max ( collector / reduce )
     * @param words
     * @return
     */
    private Function<String, Long> countLowerCase = (word) -> word.chars().filter(isLowerCaseLetter).count();
    public Optional<String> exercise7_version2(List<String> words) {
        return words.stream().max(comparing(countLowerCase));
    }

    /**
     * With reduce
     * @param words
     * @return
     */
    public Optional<String> exercise7_version3(List<String> words) {
        return words.stream().reduce((acc,element) -> comparing(countLowerCase).compare(acc,element) >= 0 ? acc:element);
    }


    /**
     * Advanced exercise 1
     *
     * @param stream
     * @param mapper
     * @param <T>
     * @param <R>
     * @return
     */
    public <T, R> List<R> map(Stream<T> stream, Function<? super T, ? extends R> mapper) {

        return stream.parallel().reduce(new ArrayList<R>(), (acc, element) -> {
                    acc.add(mapper.apply(element));
                    return acc;
                },
                (left, right) -> {
                    left.addAll(right);
                    return left;
                });
    }

    /**
     * This method solves advanced exercise 1, but returning a stream instead of a list
     *
     * @param stream
     * @param mapper
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> Stream<R> mapToStream(Stream<T> stream, Function<? super T, ? extends R> mapper) {
        Spliterator<T> iterT = stream.spliterator();
        Spliterator<R> iter = new Spliterators.AbstractSpliterator<R>(iterT.estimateSize(), Spliterator.ORDERED) {
            @Override
            public boolean tryAdvance(Consumer<? super R> action) {
                return iterT.tryAdvance(r -> action.accept(mapper.apply(r)));
            }
        };
        return StreamSupport.stream(iter, false);
    }

    /**
     * Write an implementation of the Stream function filter using only reduce and lambda expressions.
     * Again, you can return a List instead of a Stream if you want.
     *
     * @param stream
     * @param filter
     * @param <T>
     * @return
     */
    public static <T> List<T> filterAndCollectToList(Stream<T> stream, Predicate<T> filter) {
        return stream.reduce(new ArrayList<T>(), (acc, element) -> {
            if (filter.test(element)) {
                acc.add(element);
            }

            return acc;
        }, (left, right) -> {
            left.addAll(right);
            return left;
        });

    }


    public void outro() {
        Stream<String> stream = Stream.of("um", "dois", "tres");

        List<Integer> ints = stream.
                map(String::chars).flatMapToInt(x -> x).
                map(value -> (char) value).
                boxed().
                collect(Collectors.toList());
    }


    @Data
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class Artist {
        public Artist(String name, String placeOfOrigin) {
            this.name = name;
            this.placeOfOrigin = placeOfOrigin;
        }

        private final String name;
        private String placeOfOrigin;
        private Stream<Artist> members;
    }

    @Data
    public static class Album {
        private String name;
        private List<String> tracks;
    }


}
