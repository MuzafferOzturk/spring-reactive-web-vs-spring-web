package tr.reactive.demo.controller;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class DelayController {

    /*
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    *
    *
    * */
    @GetMapping("/v1/delay/{delayMillis}")
    @SneakyThrows
    public String get(@PathVariable Long delayMillis) {
        Thread.sleep(delayMillis);
        return "OK";
    }

    /*
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
        </dependency>
    *
    * */
//    @GetMapping("/v2/delay/{delayMillis}")
//    public Mono<String> getV2(@PathVariable Long delayMillis) {
//        return Mono.just("OK")
//                .delayElement(Duration.ofMillis(delayMillis));
//    }
}
