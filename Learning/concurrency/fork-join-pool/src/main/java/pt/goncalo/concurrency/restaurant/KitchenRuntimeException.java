package pt.goncalo.concurrency.restaurant;

/*
 * Created by: @author Gonçalo Silva
 * 09/06/2020
 * Something went terribly wrong and there's no fix to it
 */
public class KitchenRuntimeException extends RuntimeException{
    public KitchenRuntimeException() {
    }

    public KitchenRuntimeException(String message) {
        super(message);
    }

    public KitchenRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public KitchenRuntimeException(Throwable cause) {
        super(cause);
    }

    public KitchenRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
