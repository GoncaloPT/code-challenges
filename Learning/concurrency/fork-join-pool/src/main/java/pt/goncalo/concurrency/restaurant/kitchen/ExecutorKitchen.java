package pt.goncalo.concurrency.restaurant.kitchen;

import pt.goncalo.concurrency.restaurant.KitchenRuntimeException;
import pt.goncalo.concurrency.restaurant.KitchenStrategy;
import pt.goncalo.concurrency.restaurant.menu.Ingredient;
import pt.goncalo.concurrency.restaurant.menu.MenuEntry;
import pt.goncalo.concurrency.restaurant.menu.Order;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/*
 * Created by: @author Gonçalo Silva
 * 09/06/2020
 * Submits each ingredient preparation for a new Thread using a ExecutorService to manage the execution
 */
public class ExecutorKitchen implements KitchenStrategy {
    // Decorator, Composition over inheritance
    private final Kitchen kitchen = new Kitchen();
    private final AtomicLong orderNumber = new AtomicLong();

    @Override
    public long submitOrder(Order order) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Long curOrder = orderNumber.incrementAndGet();
        for (MenuEntry entry : order.getEntries()) {
            for (Ingredient ingredient : entry.getIngredients()) {
                executor.execute(() -> kitchen.prepareIngredient(ingredient, curOrder));
            }
        }
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
            for (MenuEntry entry : order.getEntries()) {
                kitchen.finishOrder(entry, curOrder);
            }
        } catch (InterruptedException e) {
            throw new KitchenRuntimeException(e);
        }

        return curOrder;

    }
}
