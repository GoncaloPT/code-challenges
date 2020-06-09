package pt.goncalo.concurrency.restaurant.menu;

import lombok.Data;
import lombok.Getter;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/*
 * Created by: @author Gonçalo Silva
 * 09/06/2020
 * The times are not realistic, they are scaled down so that the program can execute faster
 */
@Getter
public enum Ingredient implements Preparable{

    CHIPS(Duration.ofSeconds(5)),
    BURGER(Duration.ofSeconds(10)),
    CHEESE(Duration.ofMillis(100)),
    ONIONS(Duration.ofMillis(500));
    private final Duration preparation;


    Ingredient(Duration preparation) {
        this.preparation = preparation;
    }


}
