package tr.reactive.demo.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SpringWebController {
    private static final String URL = "http://localhost:8080";
    private final RestTemplate restTemplate;

    public SpringWebController(RestTemplateBuilder builder) {
        restTemplate = builder.rootUri(URL).build();
    }

    @GetMapping("/delay/{delayMillis}")
    public String get(@PathVariable String delayMillis) {
        return "Spring web " + restTemplate.getForObject("/v1/delay/" + delayMillis, String.class);
    }
}
