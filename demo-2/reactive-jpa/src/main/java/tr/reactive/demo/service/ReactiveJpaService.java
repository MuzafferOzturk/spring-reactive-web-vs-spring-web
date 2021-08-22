package tr.reactive.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import tr.reactive.demo.model.DemoUser;
import tr.reactive.demo.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ReactiveJpaService {
    private final UserRepository userRepository;

    public Flux<DemoUser> findByIdBetween(int start, int end) {
        return userRepository.findByIdBetween(start, end);
    }
}
