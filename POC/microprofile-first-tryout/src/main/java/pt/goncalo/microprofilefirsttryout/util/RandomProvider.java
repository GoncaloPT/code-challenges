package pt.goncalo.microprofilefirsttryout.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Created by: @author Gonçalo Silva
 * 21/05/2020
 * This factory purpose is to enable mocking of random, while still using ThreadLocalRandom.current()
 */
public final class RandomProvider {

    public Random build(){
        return ThreadLocalRandom.current();
    }
}
