package pt.goncalo.joshlong.reactivespring.scheduler;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

/**
 * Reactor allows us to interact with internal Schedulers
 */
public class SchedulerTests {
    @Test
    public void customDecorator(){
        Flux<Integer> numbersFlux = Flux
                .just(1)
                .delayElements(Duration.ofMillis(1));
        StepVerifier.create(numbersFlux).thenAwait(Duration.ofMillis(10)).expectNextCount(1).verifyComplete();
    }
}
