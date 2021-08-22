package tr.reactive.demo;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tr.reactive.demo.model.DemoUser;
import tr.reactive.demo.repository.UserRepository;

import java.util.stream.IntStream;

@SpringBootApplication
public class JpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class);
    }

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        final int dbCount = 10_000;
        return args -> {
            if (userRepository.count()< dbCount) {
                userRepository.deleteAll();
                IntStream.of(0, dbCount)
                        .forEach(integer -> {
                            DemoUser demoUser = DemoUser.builder()
                                    .identity(RandomStringUtils.randomNumeric(10))
                                    .name(RandomStringUtils.randomAlphabetic(5))
                                    .build();
                            userRepository.save(demoUser);
                        });

            }
        };
    }
}
