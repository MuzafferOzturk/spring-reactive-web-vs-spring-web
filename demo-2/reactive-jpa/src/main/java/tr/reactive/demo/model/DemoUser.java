package tr.reactive.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("demo_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemoUser {
    @Id
    private Long id;
    private String identity;
    private String name;
}
