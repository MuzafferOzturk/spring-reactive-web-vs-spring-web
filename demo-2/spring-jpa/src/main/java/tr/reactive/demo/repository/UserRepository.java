package tr.reactive.demo.repository;

import org.springframework.data.repository.CrudRepository;
import tr.reactive.demo.model.DemoUser;

import java.util.List;

public interface UserRepository extends CrudRepository<DemoUser, Long> {
    List<DemoUser> findByIdBetween(long start, long end);
}
