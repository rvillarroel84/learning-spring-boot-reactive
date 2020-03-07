package com.rvillarroel.learningspringboot.learningspringboot.controllers;

import com.rvillarroel.learningspringboot.learningspringboot.domain.Image;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Log4j2
public class Controller {

    private String API_BASE_PATH="C:/";

    @GetMapping("/images")
    Flux<Image> images(){
    return Flux.just(new Image("1", "Learning-spring-boot.jpg")
                    ,new Image("2", "Learning-spring-boot-2nd-Edition.jpg")
                    ,new Image("2", "Learning-spring-boot-3rd-Edition.jpg"));
    };

    @PostMapping(value = "/images")
    Mono<Void> create(@RequestBody Flux<Image> images){
      return images
              .map(image -> {log.info("We will save" + image + "to a Reactive DataBase soon");
                            return  image; })
              .then();
    };
}
