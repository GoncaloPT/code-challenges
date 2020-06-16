package pt.goncalo.concurrency.restaurant.kitchen;

import lombok.RequiredArgsConstructor;
import pt.goncalo.concurrency.restaurant.KitchenStrategy;
import pt.goncalo.concurrency.restaurant.menu.Ingredient;
import pt.goncalo.concurrency.restaurant.menu.MenuEntry;
import pt.goncalo.concurrency.restaurant.menu.Order;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static pt.goncalo.concurrency.restaurant.KitchenUtil.waitForPreparation;

/*
 * Created by: @author Gonçalo Silva
 * 09/06/2020
 * Submits each ingredient preparation for a new Thread using a ExecutorService to manage the execution
 */
@RequiredArgsConstructor
public class ForkJoinKitchen implements KitchenStrategy {
    private final AtomicLong orderNumber = new AtomicLong();

    // Decorator, Composition over inheritance
    private final Kitchen kitchen = new Kitchen();

    @Override
    public long submitOrder(Order order) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        for(MenuEntry entry: order.getEntries()){
            ForkedKitchen forkedKitchenOrder = new ForkedKitchen(entry, orderNumber.incrementAndGet());
            forkJoinPool.invoke(forkedKitchenOrder);
        }
        return orderNumber.get();
    }

    @RequiredArgsConstructor
    private class ForkedKitchen extends RecursiveTask<Long> {

        private final MenuEntry order;
        private final long orderNumber;
        @Override
        protected Long compute() {
            Stream<Ingredient> ingredientStream = order.getIngredients().stream();
            Collection<KitchenCook> foodProducers = ingredientStream.
                    map(ing -> new KitchenCook(ing, orderNumber))
                    .collect(Collectors.toList());

            Collection<KitchenCook> submittedTasks = ForkJoinTask.invokeAll(foodProducers);
            for(KitchenCook cook : submittedTasks){
                cook.getRawResult();
            }
            kitchen.finishOrder(order, orderNumber);

            return orderNumber;
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
            kitchen.prepareIngredient(ingredient, orderNumber);
            return orderNumber;
        }
    }
}
