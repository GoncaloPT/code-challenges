package pt.goncalo.concurrency.restaurant;

import lombok.RequiredArgsConstructor;
import pt.goncalo.concurrency.restaurant.menu.Ingredient;
import pt.goncalo.concurrency.restaurant.menu.Menu;

import java.sql.Time;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Created by: @author Gonçalo Silva
 * 09/06/2020
 * The Restaurant kitchen
 * It receives an order an prepares it. Each order takes a specific amount of time to be prepared
 */
public class Kitchen {

    private AtomicLong orderNumber = new AtomicLong();

    /**
     * Receives an order and assigns an sequential id to it
     *
     * @return
     */
    public Long submitOrder(Menu order) {
        Long curOrder = orderNumber.incrementAndGet();
        prepareOrder(order,curOrder);
        return curOrder;
    }

    public Long submitParallelOrder(Menu order){
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkedKitchen forkedKitchenOrder = new ForkedKitchen(order);
        forkJoinPool.execute(forkedKitchenOrder);
        return forkedKitchenOrder.join();
    }

    public Long submitExecutorServiceOrder(Menu order){
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (Ingredient ingredient : order.getIngredients()) {
            Long curOrder = orderNumber.incrementAndGet();
            executor.execute( () -> prepareIngredient(ingredient,curOrder));

        }
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
            executor.execute(() -> {
                try {
                    Thread.sleep(order.getAdditionalPrepareTime().toMillis());
                } catch (InterruptedException e) {
                    throw new KitchenRuntimeException(e);
                }
            });
        } catch (InterruptedException e) {
            throw new KitchenRuntimeException(e);
        }

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkedKitchen forkedKitchenOrder = new ForkedKitchen(order);
        forkJoinPool.execute(forkedKitchenOrder);
        return forkedKitchenOrder.join();

    }

    /**
     * Assigns a
     *
     * @param order
     * @return
     */
    public void prepareOrder(Menu order, Long curOrder) {
        System.out.println("[Order "+curOrder +"] Started preparation of " + order.name());
        for (Ingredient ingredient : order.getIngredients()) {
            prepareIngredient(ingredient,curOrder);
        }
        // Additional waiting time to assemble all the ingredients
        try {
            Thread.sleep(order.getAdditionalPrepareTime().toMillis());
        } catch (InterruptedException ie) {
            throw new KitchenRuntimeException(ie);
        }
        System.out.println("[Order "+curOrder + " ] Ready!");
    }

    public void prepareIngredient(Ingredient ingredient, Long curOrder) {
        System.out.println("[Order "+curOrder +"] Started preparation of " + ingredient.name());
        Duration preparationTime = ingredient.getPreparation();
        try {
            Thread.sleep(preparationTime.toMillis());
        } catch (InterruptedException ie) {
            throw new KitchenRuntimeException(ie);
        }
        System.out.println("[Order "+curOrder + " ] "+ ingredient.name() + " prepared");


    }

    @RequiredArgsConstructor
    private class ForkedKitchen extends RecursiveTask<Long>{

        private final Menu order;

        @Override
        protected Long compute() {
            Stream<Ingredient> ingredientStream = order.getIngredients().stream();
            long curOrder = orderNumber.incrementAndGet();
            Collection<KitchenCook> foodProducers = ingredientStream.
                    map(ing -> new KitchenCook(ing, curOrder))
                    .collect(Collectors.toList());
            ForkJoinTask.invokeAll(foodProducers);
            // Additional waiting time to assemble all the ingredients
            try {
                Thread.sleep(order.getAdditionalPrepareTime().toMillis());
            } catch (InterruptedException ie) {
                throw new KitchenRuntimeException(ie);
            }

            return curOrder;
        }
    }


    private class KitchenCook extends RecursiveTask<Long> {
        private final Ingredient ingredient;
        private final long orderNumber;
        public KitchenCook(Ingredient ingredient, long orderNumber) {
            this.ingredient = ingredient;
            this.orderNumber = orderNumber;
        }

        @Override
        protected Long compute() {
            prepareIngredient(ingredient,orderNumber);
            return orderNumber;
        }
    }
}
