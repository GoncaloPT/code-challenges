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

import static pt.goncalo.concurrency.restaurant.KitchenUtil.waitForPreparation;

/*
 * Created by: @author Gonçalo Silva
 * 09/06/2020
 * The Restaurant kitchen
 * It receives an order an prepares it. Each order takes a specific amount of time to be prepared
 */
public class OneManKitchen implements KitchenStrategy {

    private AtomicLong orderNumber = new AtomicLong();
    // Decorator, Composition over inheritance
    private final Kitchen kitchen = new Kitchen();

    /**
     * Receives an order and assigns an sequential id to it
     *
     * @return
     */
    private void submitOrder(MenuEntry order, long curOrder) {
        for (Ingredient ingredient : order.getIngredients()) {
            kitchen.prepareIngredient(ingredient, curOrder);
        }
        kitchen.finishOrder(order, curOrder);
    }


    /**
     * @param order
     * @return The order number
     * @see KitchenStrategy#submitOrder(Order)
     * Submits the entries of the order, one by one for the lazy one task at a time only cook
     */
    @Override
    public long submitOrder(Order order) {
        long curOrder = orderNumber.incrementAndGet();
        for (MenuEntry e : order.getEntries()) {
            submitOrder(e, curOrder);
        }
        return curOrder;
    }
}
