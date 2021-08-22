package tr.reactive.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import tr.reactive.demo.model.DemoUser;

public interface UserRepository extends ReactiveCrudRepository<DemoUser, Long> {
    Flux<DemoUser> findByIdBetween(long start, long end);
}
