package es.sarman.eurekaconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@FeignClient(name = "PRUEBATECNICASPRINGBOOT", path = "/heroes")
public interface HeroesClient {

    @GetMapping("/")
    public ResponseEntity<List<Hero>> listHeroes();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Hero showHero(@PathVariable int id);

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<Hero> listHeroes(@RequestParam String query);

}
