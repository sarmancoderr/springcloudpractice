package es.sarman.pruebatecnica.Heroes;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HeroRepository extends CrudRepository<Hero, Integer> {

    List<Hero> findAllByNameIgnoreCaseContaining(String name);
    Hero findByName(String name);

}
