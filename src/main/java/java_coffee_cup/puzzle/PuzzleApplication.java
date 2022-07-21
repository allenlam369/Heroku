package java_coffee_cup.puzzle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PuzzleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PuzzleApplication.class, args);
	}

	@RequestMapping("/")
	String index() {
		return "index";
	}

	@RequestMapping(value = "/hello")
	public String hello() {
		return "Hello!";
	}

}
