package pt.goncalo.microprofilefirsttryout.repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pt.goncalo.microprofilefirsttryout.model.Person;

import java.util.Random;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Created by: @author Gonçalo Silva
 * 20/05/2020
 */
class LocalMemoryPersonRepositoryTest {


    private Random randomMock = mock(Random.class);

    @ParameterizedTest
    @CsvSource("Gonçalo,32")
    void find(String name, int age) {
        when(randomMock.nextInt(99)).thenReturn(age-10);
        LocalMemoryPersonRepository repo = new LocalMemoryPersonRepository(randomMock);

        Person result = repo.find(name);
        Person expectedResult = Person.builder().age(age).name(name).id(result.getId()).build();
        assertEquals(expectedResult,result);
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void list() {
    }
}