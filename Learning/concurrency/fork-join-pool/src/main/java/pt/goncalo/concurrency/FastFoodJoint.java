package pt.goncalo.concurrency;

import pt.goncalo.concurrency.restaurant.KitchenStrategy;
import pt.goncalo.concurrency.restaurant.kitchen.ExecutorKitchen;
import pt.goncalo.concurrency.restaurant.kitchen.ForkJoinKitchen;
import pt.goncalo.concurrency.restaurant.kitchen.Kitchen;
import pt.goncalo.concurrency.restaurant.kitchen.OneManKitchen;
import pt.goncalo.concurrency.restaurant.menu.MenuEntry;
import pt.goncalo.concurrency.restaurant.menu.Order;

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

        final int repeatCount = Integer.decode(args[0]);
        long counts;
        long startTime;
        long stopTime;

        long[] singleThreadTimes = new long[repeatCount];
        long[] forkedThreadTimes = new long[repeatCount];
        long[] executorThreadTimes = new long[repeatCount];

        Order order = Order.
                of(
                        MenuEntry.HOUSE_BURGER,
                        MenuEntry.CHEESE_BURGER,
                        MenuEntry.HOTDOG_MENU
                );

//        for (int i = 0; i < repeatCount; i++) {
//            KitchenStrategy kitchen = new OneManKitchen();
//            startTime = System.currentTimeMillis();
//
//            counts = kitchen.submitOrder(order);
//            stopTime = System.currentTimeMillis();
//            singleThreadTimes[i] = (stopTime - startTime);
//            System.out.println(i + " , single thread kitchen took " + singleThreadTimes[i] + "ms");
//        }
        System.out.println("**************************************************************");

        for (int i = 0; i < repeatCount; i++) {
            KitchenStrategy kitchen = new ExecutorKitchen();
            startTime = System.currentTimeMillis();
            counts = kitchen.submitOrder(order);
            stopTime = System.currentTimeMillis();
            executorThreadTimes[i] = (stopTime - startTime);
            System.out.println(i + " , ExecutorService  kitchen took " + forkedThreadTimes[i] + "ms");
        }
        System.out.println("**************************************************************");
        for (int i = 0; i < repeatCount; i++) {
            KitchenStrategy kitchen = new ForkJoinKitchen();
            startTime = System.currentTimeMillis();
            counts = kitchen.submitOrder(order);
            stopTime = System.currentTimeMillis();
            forkedThreadTimes[i] = (stopTime - startTime);

            System.out.println(i + " ,  ForkJoin kitchen took " + executorThreadTimes[i] + "ms");
        }

        System.out.println("Single thread average = " + LongStream.of(singleThreadTimes).sum() /repeatCount);
        System.out.println("ForkJoin thread average = " + LongStream.of(forkedThreadTimes).sum() / repeatCount);
        System.out.println("ExecutorService thread average = " + LongStream.of(executorThreadTimes).sum() / repeatCount);
    }



}
