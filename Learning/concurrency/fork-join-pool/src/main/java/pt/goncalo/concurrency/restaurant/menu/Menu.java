package pt.goncalo.concurrency.restaurant.menu;

import lombok.Data;
import lombok.Getter;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * Created by: @author Gonçalo Silva
 * 09/06/2020
 */
@Getter
public enum Menu {

    HOUSE_BURGER(Duration.ofSeconds(5),Ingredient.CHIPS, Ingredient.BURGER, Ingredient.CHEESE, Ingredient.ONIONS);

    private final List<Ingredient> ingredients;
    private final Duration additionalPrepareTime;


    Menu(Ingredient... ingredients) {
        this.ingredients = Arrays.asList(ingredients);
        //not in use
        this.additionalPrepareTime = Duration.ZERO;

    }

    Menu(Duration additionalPrepareTime, Ingredient... ingredients) {
        this.additionalPrepareTime = additionalPrepareTime;
        this.ingredients = Arrays.asList(ingredients);
    }

}
