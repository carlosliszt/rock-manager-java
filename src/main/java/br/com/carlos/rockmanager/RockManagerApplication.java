package br.com.carlos.rockmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RockManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RockManagerApplication.class, args);
    }

}
