package pt.goncalo.playground.graal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pt.goncalo.playground.graal.entity.PersonEntity;
import pt.goncalo.playground.graal.repository.PersonRepository;

import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories
public class GraalApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraalApplication.class, args);
		System.out.println("HELLO!!!!");
    }

    private final PersonRepository personRepository;

    public GraalApplication(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Makes sure a PersonEntity with id 1 exists on the database
     * @return
     */
    @Bean
    public CommandLineRunner runOnStartup(){
        return args -> {
            Optional<PersonEntity> maybePerson = personRepository.findById(1L);
            PersonEntity p = maybePerson.orElse(personRepository.save(new PersonEntity(1L,"Gonçalo")));

            personRepository.findAll().forEach((personEntity -> System.out.println(">\t person is " +personEntity.getName())));

        };
    }

}
