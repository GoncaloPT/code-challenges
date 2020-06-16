package pt.goncalo.concurrency.restaurant.kitchen;

import pt.goncalo.concurrency.restaurant.menu.Ingredient;
import pt.goncalo.concurrency.restaurant.menu.MenuEntry;

import static pt.goncalo.concurrency.restaurant.KitchenUtil.waitForPreparation;

/*
 * Created by: @author Gonçalo Silva
 * 09/06/2020
 */
public class Kitchen {

    /**
     * Assigns a
     *
     * @param order
     * @return
     */
    public void finishOrder(MenuEntry order, Long curOrder) {
        // Additional waiting time to assemble all the ingredients
        waitForPreparation(order.getAdditionalPrepareTime());
        System.out.println("[Order " + curOrder + " ] Ready!");
    }

    public void prepareIngredient(Ingredient ingredient, Long curOrder) {
        System.out.println("[Order " + curOrder + "] Started preparation of " + ingredient.name());
        waitForPreparation(ingredient.getPreparation());
        System.out.println("[Order " + curOrder + " ] " + ingredient.name() + " prepared");
    }
}
