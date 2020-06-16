package pt.goncalo.concurrency.restaurant.menu;

import lombok.Getter;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/*
 * Created by: @author Gonçalo Silva
 * 09/06/2020
 */
@Getter
public enum MenuEntry {

    HOUSE_BURGER(Duration.ofSeconds(5),Ingredient.CHIPS, Ingredient.BURGER, Ingredient.CHEESE, Ingredient.ONIONS),
    CHEESE_BURGER(Duration.ofSeconds(4),Ingredient.CHIPS, Ingredient.BURGER, Ingredient.CHEESE),
    BURGER(Duration.ofSeconds(4),Ingredient.CHIPS, Ingredient.BURGER),
    HOTDOG_MENU(Duration.ofSeconds(2), Ingredient.CHIPS, Ingredient.SAUSAGE ),
    HOTDOG(Duration.ofSeconds(1),  Ingredient.SAUSAGE );

    private final List<Ingredient> ingredients;
    private final Duration additionalPrepareTime;


    MenuEntry(Ingredient... ingredients) {
        this.ingredients = Arrays.asList(ingredients);
        //not in use
        this.additionalPrepareTime = Duration.ZERO;

    }

    MenuEntry(Duration additionalPrepareTime, Ingredient... ingredients) {
        this.additionalPrepareTime = additionalPrepareTime;
        this.ingredients = Arrays.asList(ingredients);
    }

}
