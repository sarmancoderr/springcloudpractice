package es.sarman.pruebatecnica.Heroes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class IHeroServiceTest {

    @Autowired IHeroService heroService;
    @Autowired HeroRepository heroRepository;

    @BeforeEach
    void setUp() {
        List<Hero> allHeroes = (List<Hero>) heroRepository.findAll();
        if (allHeroes.size() > 0) return;

        heroRepository.save(new Hero("Superman"));
        heroRepository.save(new Hero("Batman"));
        heroRepository.save(new Hero("Manolito el fuerte"));
    }

    @Test
    void getHeroes() {
        List<Hero> heroes = heroService.getHeroes();
        assertEquals(heroes.size(), 3);
    }

    @Test
    void getHero() {
        Hero hero2 = heroService.getHero(2);
        Hero hero1 = heroService.getHero(1);

        assertTrue(hero2.getName().equals("Batman"));
        assertTrue(hero1.getName().equals("Superman"));
    }

    @Test
    void searchHeroes() {
        List<Hero> heroesQuery = (List<Hero>) heroService.searchHeroes("man");
        assertEquals(heroesQuery.size(), 3);

        List<Hero> heroesQuery2 = (List<Hero>) heroService.searchHeroes("bat");
        assertEquals(heroesQuery2.size(), 1);
    }

    @Test
    void updateHero() {
        HeroDTO heroDTO = new HeroDTO("Batman nuevo nombre");
        Hero hero2 = heroService.getHero(2);

        assertTrue(hero2.getName().equals("Batman"));

        Hero updated = heroService.updateHero(2, heroDTO);
        assertTrue(updated.getName().equals(heroDTO.getName()));
    }

    @Test
    void removeHero() {
        assertTrue(heroService.removeHero(2));
        List<Hero> heroes = heroService.getHeroes();
        assertEquals(heroes.size(), 2);
    }
}