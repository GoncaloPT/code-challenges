package pt.goncalo.concurrency.restaurant;

import pt.goncalo.concurrency.restaurant.menu.Order;

/*
 * Created by: @author Gonçalo Silva
 * 09/06/2020
 */
public interface KitchenStrategy {
    public long submitOrder(Order order);
}
