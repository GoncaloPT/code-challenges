package pt.goncalo.streams;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOf {

    /**
     * Doubt: can he iterate on Streams made of lists of different kinds?
     */
    public void allTogether(){
        List ints = List.of(1,2,3);
        List strings = List.of("Joao","Maria", "Cascais");

        //Stream.of(strings,ints).flatMap(Stream::of).forEach(System.out::println);
        Stream.of(strings,ints).forEach(System.out::println);

    }

    /**
     * Can we use a stream filter without cascading operations?
     */
    public void streamWithoutAssignment(){
        Stream<String> people = Stream.of("Maria","Joaquina","Zacarias");
        
        people.filter(x -> x.startsWith("J"));
        people.forEach(System.out::println);

    }

    /**
     * Is the range exclusive or inclusive?
     */
    public void range(){
        // answer: public static IntStream range(int startInclusive, int endExclusive) {
        IntStream range = IntStream.range(1,4);
        range.forEach(System.out::println);


        //Stream<Integer> range2 = IntStream.range(1,4).boxed();
    }

    public static void main(String[] args)  {


        //new StreamOf().streamWithoutAssignment();
        new StreamOf().range();
    }


}
