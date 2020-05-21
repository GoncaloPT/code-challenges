package pt.goncalo.microprofilefirsttryout.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import pt.goncalo.microprofilefirsttryout.model.Person;
import pt.goncalo.microprofilefirsttryout.util.RandomProvider;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Created by: @author Gonçalo Silva
 * 20/05/2020
 */
@ApplicationScoped
@RequiredArgsConstructor
@Log
public class LocalMemoryPersonRepository implements PersonRepository {
    // Not the ideal way of using ThreadLocalRandom. current() should be called when
    private final RandomProvider randomProvider;
    private static final String MY_NAME = "Gonçalo";
    public LocalMemoryPersonRepository(){
        this.randomProvider = new RandomProvider();
    }


    @Override
    public Person find(String name) {
        return Person.builder().name(name).id(UUID.randomUUID().toString()).age(10+randomProvider.build().nextInt(99)).build();
    }

    @Override
    public Person get(String id) {
        return Person.builder().id(id).name(MY_NAME).age(32).build();
    }

    /**
     * Lists Persons by collecting the results of invoking {@link #find(String)} n times
     * N = random [1-30]
     * @return
     */
    @Override
    public List<Person> list() {

        return Stream.generate(() -> find("OneMore"))
                .limit(1L + randomProvider.build().nextInt(30))
                .collect(Collectors.toList());
    }
}
