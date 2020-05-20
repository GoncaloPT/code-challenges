import chapter6.Chapter6;


import junit.extensions.Benchmark;
import junit.extensions.TimingExtension;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Test cases for chapter 6 exercises
 */
@Benchmark
@Log
@ExtendWith(TimingExtension.class)
public class Chapter6Tests {

    /**
     * The code in Example 6-10 sequentially sums the squares of numbers in a Stream. Make it run in parallel using streams.
     * Example 6-10. Sequentially summing the squares of numbers in a list
     *
     *
     */
    @Test
    public void testExercise1(){
        IntStream range = IntStream.of(1,2,3,4,5);
        Integer expectedResult = 1+2*2+3*3+4*4+5*5;
        Integer result = new Chapter6().exercise1(range);
        Assertions.assertEquals(expectedResult,result);
    }

    /**
     * The code in Example 6-11 multiplies every
     * number in a list together and multiplies the result by 5.
     * This works fine sequentially, but has a bug when running in parallel.
     * Make the code run in parallel using streams and fix the bug.
     */
    @RepeatedTest(1)
    @Benchmark
    public void testExercise2(){
        Stream<Integer> infiniteStream = Stream.iterate(1,x-> x+1);


        //Stream<Integer> infiniteStream = Stream.of(1,2,3,4,5);
        List<Integer> range = infiniteStream.limit(50000).collect(toList());

        ;
        final AtomicInteger expectedResult = new AtomicInteger();
        range.stream().peek(System.out::print).forEach(value -> expectedResult.set(expectedResult.intValue()*value));


        Integer result = new Chapter6().exercise2(range);
        System.out.println("result = " + result);
        System.out.println("expectedResult = " + expectedResult);
        Assertions.assertEquals(expectedResult.intValue(),result);
    }

}
