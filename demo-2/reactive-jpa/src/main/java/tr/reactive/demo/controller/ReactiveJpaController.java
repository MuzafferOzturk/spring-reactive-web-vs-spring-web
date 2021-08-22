package tr.reactive.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import tr.reactive.demo.model.DemoUser;
import tr.reactive.demo.service.ReactiveJpaService;

@RestController
@RequiredArgsConstructor
public class ReactiveJpaController {

    private final ReactiveJpaService reactiveJpaService;

    @GetMapping("/user")
    public Flux<DemoUser> findByIdBetween(@RequestParam("start") int start, @RequestParam("end") int end) {
        return reactiveJpaService.findByIdBetween(start, end);
    }
}
