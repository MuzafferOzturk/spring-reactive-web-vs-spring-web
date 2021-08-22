package tr.reactive.demo.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "demo_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class DemoUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String identity;
    private String name;
}
