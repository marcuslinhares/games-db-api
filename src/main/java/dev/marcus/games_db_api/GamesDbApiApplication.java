package dev.marcus.games_db_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class GamesDbApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamesDbApiApplication.class, args);
	}

	@RestController
	@RequestMapping(path = "/ping")
	public class observer {
		
		@GetMapping
		public ResponseEntity<String> ping() {
			return ResponseEntity.status(HttpStatus.OK).body("Pong");
		}
	}

}
