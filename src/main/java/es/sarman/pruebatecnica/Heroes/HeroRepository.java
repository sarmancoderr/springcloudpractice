package es.sarman.pruebatecnica.Heroes;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HeroRepository extends CrudRepository<Hero, Integer> {

    List<Hero> findAllByNameIgnoreCaseContaining(String name);
    Optional<Hero> findByName(String name);

}
