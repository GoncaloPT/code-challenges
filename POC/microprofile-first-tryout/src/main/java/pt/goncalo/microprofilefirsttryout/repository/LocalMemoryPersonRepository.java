package pt.goncalo.microprofilefirsttryout.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import pt.goncalo.microprofilefirsttryout.model.Person;
import pt.goncalo.microprofilefirsttryout.util.RandomProvider;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
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
    private final RandomProvider randomProvider;
    private static final String MY_NAME = "Gonçalo";
    public LocalMemoryPersonRepository(){
        this.randomProvider = new RandomProvider();
    }

    /**
     *
     * @param name
     * @throws IllegalArgumentException if name is null
     * @return Person
     */
    @Override
    public Person find(String name) {
        Objects.requireNonNull(name,"Name must be provided");
        return Person.builder().name(name).id(UUID.randomUUID().toString()).age(10+randomProvider.build().nextInt(99)).build();
    }

    /**
     *
     * @param id
     * @throws IllegalArgumentException if id is null
     * @return found Person
     */
    @Override
    public Person get(String id) {
        Objects.requireNonNull(id, () -> "Id must not be null");
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
