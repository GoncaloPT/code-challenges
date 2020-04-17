package chapter5;

import chapter3.Chapter3;
import lombok.var;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 *
 */
public class Collectors {
    /**
     * Find the artist with the longest name.
     * You should implement this using a Collector and the reduce higher-order function from Chapter 3.
     * This one is the first option
     */
    public Function<Chapter3.Artist, Integer> countArtistName = artist -> artist.getName().length();

    public Optional<Chapter3.Artist> findArtistWithLongestName(List<Chapter3.Artist> artists) {
        return artists.stream().reduce((acc, element) -> countArtistName.apply(acc) >= countArtistName.apply(element) ? acc : element);
    }

    public Optional<Chapter3.Artist> findArtistWithLongestName2(List<Chapter3.Artist> artists) {
        return artists.stream().max(Comparator.comparingInt(x -> x.getName().length()));
    }

    /**
     * Exercice 2B
     *
     * @param names
     * @return
     */
    public Map<String, Long> countWordsInStream(Stream<String> names) {
        Map<String, Long> countByName = names.collect(groupingBy(x -> x, counting()));
        return countByName;
    }

    /**
     * Implement Collectors.groupingBy as a custom collector.
     * You don’t need to provide a downstream collector, so just implementing the simplest variant is fine.
     */
    public static class GroupingBy<T, R> implements Collector<T, Map<R, List<T>>, Map<R, List<T>>> {

        /**
         * This is the identity
         *
         * @return
         */
        private final Function<? super T, ? extends R> classifier;

        public GroupingBy(Function<? super T, ? extends R>  classifier) {
            this.classifier = classifier;
        }

        @Override
        public Supplier<Map<R, List<T>>> supplier() {
            return HashMap::new;
        }

        /**
         * The acumulator is actually the hashmap
         *
         * @return
         */
        @Override
        public BiConsumer<Map<R, List<T>>, T> accumulator() {
            return (acc, element) -> {

                var key = classifier.apply(element);

                List<T> elements = acc.computeIfAbsent(key, (k) -> new ArrayList<>());
                elements.add(element);

            };
        }

        @Override
        public BinaryOperator<Map<R, List<T>>> combiner() {
            return (left, right) -> {
                right.forEach((key, value) -> {
                    left.merge(key, value, (leftValue, rightValue) -> {
                        leftValue.addAll(rightValue);
                        return leftValue;
                    });
                });
                return left;
            };
        }

        @Override
        public Function<Map<R, List<T>>, Map<R, List<T>>> finisher() {
            return null;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return null;
        }
    }

}
