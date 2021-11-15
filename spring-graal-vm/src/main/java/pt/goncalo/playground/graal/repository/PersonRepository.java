package pt.goncalo.playground.graal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.goncalo.playground.graal.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
}
