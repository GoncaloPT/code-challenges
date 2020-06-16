package pt.goncalo.concurrency.restaurant;

import java.time.Duration;

/*
 * Created by: @author Gonçalo Silva
 * 09/06/2020
 */
public class KitchenUtil {
    public static void waitForPreparation(Duration duration) {
        try {
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException ie) {
            throw new KitchenRuntimeException(ie);
        }
    }
}
