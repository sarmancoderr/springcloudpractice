package es.sarman.pruebatecnica.Heroes;

import es.sarman.pruebatecnica.Heroes.Exceptions.ExistingHeroException;
import es.sarman.pruebatecnica.Heroes.Exceptions.HeroNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IHeroServiceImpl implements IHeroService {

    @Autowired HeroRepository heroRepository;

    @Override
    public List<Hero> getHeroes() {
        return (List<Hero>) heroRepository.findAll();
    }

    @Override
    public Hero getHero(int id) {
        Optional<Hero> optionalHero = heroRepository.findById(id);

        if (!optionalHero.isPresent()) {
            throw new HeroNotFoundException();
        }

        return optionalHero.get();
    }

    @Override
    public List<Hero> searchHeroes(String query) {
        return heroRepository.findAllByNameIgnoreCaseContaining(query);
    }

    @Override
    public Hero updateHero(int id, HeroDTO update) {
        Hero existingHero = heroRepository.findByName(update.getName());

        if (existingHero != null) {
            throw new ExistingHeroException();
        }

        Optional<Hero> optionalHero = heroRepository.findById(id);

        if (!optionalHero.isPresent()) {
            throw new HeroNotFoundException();
        }

        Hero hero = optionalHero.get();
        hero.setName(update.getName());
        return heroRepository.save(hero);
    }

    @Override
    public boolean removeHero(int id) {
        Optional<Hero> optionalHero = heroRepository.findById(id);

        if (!optionalHero.isPresent()) {
            throw new HeroNotFoundException();
        }

        Hero hero = optionalHero.get();
        heroRepository.delete(hero);
        return true;
    }
}
