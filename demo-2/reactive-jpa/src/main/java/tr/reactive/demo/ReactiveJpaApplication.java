package tr.reactive.demo;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import tr.reactive.demo.model.DemoUser;
import tr.reactive.demo.repository.UserRepository;

@SpringBootApplication
public class ReactiveJpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReactiveJpaApplication.class);
    }

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        final int dbCount = 10_000;
        return args -> {
            if (userRepository.count().block() < dbCount) {
                userRepository.deleteAll().block();
                Flux.range(0, dbCount)
                        .log()
                        .subscribe(integer -> {
                            DemoUser demoUser = DemoUser.builder()
                                    .identity(RandomStringUtils.randomNumeric(10))
                                    .name(RandomStringUtils.randomAlphabetic(5))
                                    .build();
                            userRepository.save(demoUser).block();
                        });

            }
        };
    }
}
