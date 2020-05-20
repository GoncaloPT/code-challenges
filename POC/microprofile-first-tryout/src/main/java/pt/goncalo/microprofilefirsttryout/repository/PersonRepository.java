package pt.goncalo.microprofilefirsttryout.repository;

import pt.goncalo.microprofilefirsttryout.model.Person;

import java.util.List;
import java.util.UUID;

/*
 * Created by: @author Gonçalo Silva
 * 20/05/2020
 * Implemented as in memory repository for
 */
public interface PersonRepository {
    Person find(String name);
    Person get(String id);
    List<Person> list();

}
