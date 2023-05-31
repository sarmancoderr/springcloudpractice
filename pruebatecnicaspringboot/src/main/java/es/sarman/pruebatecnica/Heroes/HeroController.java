package es.sarman.pruebatecnica.Heroes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    @Autowired IHeroService heroService;

    @GetMapping("/")
    public ResponseEntity<List<Hero>> listHeroes() {
        return new ResponseEntity<>(heroService.getHeroes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Hero showHero(@PathVariable int id) {
        return heroService.getHero(id);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<Hero> listHeroes(@RequestParam String query) {
        return heroService.searchHeroes(query);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Hero updateHero(@PathVariable int id, @RequestBody HeroDTO heroDTO) {
        return heroService.updateHero(id, heroDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteHero(@PathVariable int id) {
        return heroService.removeHero(id);
    }

}
