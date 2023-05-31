package es.sarman.eurekaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.HeaderParam;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
@RequestMapping("/heroes")
public class EurekaconsumerApplication {

	@Autowired
	private HeroesClient heroesClient;

	public static void main(String[] args) {
		SpringApplication.run(EurekaconsumerApplication.class, args);
	}

	@GetMapping("/")
	public ResponseEntity<List<Hero>> listHeroes() {
		return heroesClient.listHeroes();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Hero showHero(@PathVariable int id) {return heroesClient.showHero(id);}

	@GetMapping("/search")
	@ResponseStatus(HttpStatus.OK)
	public List<Hero> listHeroes(@RequestParam String query) {return heroesClient.listHeroes(query);}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Hero updateHero(@PathVariable int id, @RequestBody HeroDTO heroDTO, @RequestHeader("Authorization") String header) {
		System.out.println(header);

		return heroesClient.updateHero(id, heroDTO, header);
	}

}
