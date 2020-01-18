package de.embl.datarest.peoplebase.repository;

import de.embl.datarest.peoplebase.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
}
