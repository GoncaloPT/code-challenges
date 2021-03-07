package pt.goncalo.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class StreamSort {

    public static class NotSortable{
        private final int value;

        public NotSortable(int value) {
            this.value = value;
        }
    }

    /**
     * Doubt, what happens when we sort a stream of objects that are not {@link Comparable}
     * Response: Throws ClassCastException
     */
    public void sortThem(){
        var stream = Stream.of(new NotSortable(1), new NotSortable(0));
        stream.sorted().forEach(System.out::println);
    }

    public void differentTypes(){
        Integer [] array = {1,2,3};
        Arrays.sort(array, (var a,var b) -> a-b );

        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }

        Stream<Integer> ints = Stream.of(1,2,3);
        ints.sorted(Comparator.comparingInt((Integer a) -> -a)).forEachOrdered(System.out::println);

    }

    public static void main(String[] args) {
        new StreamSort().differentTypes();
    }
}
