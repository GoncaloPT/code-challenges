package pt.goncalo.concurrency.restaurant.menu;

import lombok.Data;

import java.util.Arrays;
import java.util.Collection;

/*
 * Created by: @author Gonçalo Silva
 * 09/06/2020
 */
@Data
public class Order {
    private final Collection<MenuEntry> entries;

    public Order(Collection<MenuEntry> entries) {
        this.entries = entries;
    }

    public static Order of(MenuEntry... entries) {
        if (entries == null || entries.length < 1) {
            throw new IllegalArgumentException("An order must have Menu entries");
        }
        return new Order(Arrays.asList(entries));
    }
}
