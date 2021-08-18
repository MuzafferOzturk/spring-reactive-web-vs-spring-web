package tr.reactive.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class SpringReactiveWebController {
    private static final String URL = "http://localhost:8080";
    private final WebClient client;

    public SpringReactiveWebController() {
        client = WebClient.create(URL);
    }

    @GetMapping(value = "/delay/{delayMillis}")
    public Mono<String> get(@PathVariable String delayMillis) {
        return client
                .get()
                .uri("/v1/delay/" + delayMillis)
                .retrieve()
                .bodyToMono(String.class)
                .map(s -> "Reactive " + s);
    }
}
