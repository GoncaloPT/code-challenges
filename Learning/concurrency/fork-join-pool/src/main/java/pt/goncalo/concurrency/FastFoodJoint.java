package pt.goncalo.concurrency;

import pt.goncalo.concurrency.restaurant.Kitchen;
import pt.goncalo.concurrency.restaurant.menu.Menu;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/*
 * Created by: @author Gonçalo Silva
 * 09/06/2020
 * The Fast Food Joint is a restaurant that offers fast food.
 * In order to be fast, we need to test different strategies to deliver food as fast as we can
 *
 * Current tests with:
 * - Single thread code synchronous code
 * - ForkJoin framework ( the code has blocks [ Thread.sleep ] so maybe not the best approach )
 * - Executor service
 */
public class FastFoodJoint {


    public static void main(String [] args){
        Kitchen kitchen = new Kitchen();
        final int repeatCount = Integer.decode(args[0]);
        long counts;
        long startTime;
        long stopTime;

        long[] singleThreadTimes = new long[repeatCount];
        long[] forkedThreadTimes = new long[repeatCount];
        long[] executorThreadTimes = new long[repeatCount];



        for (int i = 0; i < repeatCount; i++) {
            startTime = System.currentTimeMillis();
            counts = kitchen.submitOrder(Menu.HOUSE_BURGER);
            stopTime = System.currentTimeMillis();
            singleThreadTimes[i] = (stopTime - startTime);
            System.out.println(counts + " , single thread kitchen took " + singleThreadTimes[i] + "ms");
        }

        for (int i = 0; i < repeatCount; i++) {
            startTime = System.currentTimeMillis();
            counts = kitchen.submitParallelOrder(Menu.HOUSE_BURGER);
            stopTime = System.currentTimeMillis();
            forkedThreadTimes[i] = (stopTime - startTime);
            System.out.println(counts + " , ForkJoin thread kitchen took " + forkedThreadTimes[i] + "ms");
        }

        for (int i = 0; i < repeatCount; i++) {
            startTime = System.currentTimeMillis();
            counts = kitchen.submitExecutorServiceOrder(Menu.HOUSE_BURGER);
            stopTime = System.currentTimeMillis();
            executorThreadTimes[i] = (stopTime - startTime);
            System.out.println(counts + " , ExecutorService  kitchen took " + executorThreadTimes[i] + "ms");
        }

        System.out.println("Single thread average = " + LongStream.of(singleThreadTimes).sum() /repeatCount);
        System.out.println("ForkJoin thread average = " + LongStream.of(forkedThreadTimes).sum() / repeatCount);
        System.out.println("ExecutorService thread average = " + LongStream.of(executorThreadTimes).sum() / repeatCount);
    }



}
