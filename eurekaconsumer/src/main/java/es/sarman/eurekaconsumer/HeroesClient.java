package es.sarman.eurekaconsumer;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.HeaderParam;
import java.util.List;

@FeignClient(
        path = "/heroes",
        name = "PRUEBATECNICASPRINGBOOT"
)
public interface HeroesClient {

    @GetMapping("/")
    public ResponseEntity<List<Hero>> listHeroes();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Hero showHero(@PathVariable int id);

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<Hero> listHeroes(@RequestParam String query);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Headers("Authorization: Basic eWVyOmdhbGVt")
    public Hero updateHero(@PathVariable int id, @RequestBody HeroDTO heroDTO, @RequestHeader("Authorization") String header);

}
