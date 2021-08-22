package tr.reactive.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.reactive.demo.model.DemoUser;
import tr.reactive.demo.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JpaService {
    private final UserRepository userRepository;

    public List<DemoUser> findByIdBetween(int start, int end) {
        return userRepository.findByIdBetween(start, end);
    }
}
