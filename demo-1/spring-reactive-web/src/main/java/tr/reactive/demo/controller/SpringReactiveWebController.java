package tr.reactive.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class SpringReactiveWebController {
    private static final String URL = "http://localhost:8080";
    private final WebClient client;

    public SpringReactiveWebController() {
        client = WebClient.create(URL);
    }

    @GetMapping(value = "/delay/{delayMillis}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> get(@PathVariable String delayMillis) {
        return Flux.range(1, 100000).map(integer -> String.valueOf(integer)).delayElements(Duration.ofMillis(500)).log();
//        return client
//                .get()
//                .uri("/v1/delay/" + delayMillis)
//                .retrieve()
//                .bodyToMono(String.class)
//                .map(s -> "Reactive " + s);
    }
}
