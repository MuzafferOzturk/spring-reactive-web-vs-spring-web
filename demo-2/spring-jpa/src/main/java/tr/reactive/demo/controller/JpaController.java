package tr.reactive.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.reactive.demo.model.DemoUser;
import tr.reactive.demo.service.JpaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JpaController {

    private final JpaService jpaService;

    @GetMapping("/user")
    public List<DemoUser> findByIdBetween(@RequestParam("start") int start, @RequestParam("end") int end) {
        return jpaService.findByIdBetween(start, end);
    }
}
