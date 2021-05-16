package br.com.course.ms.oauth.server.domain;

import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor(staticName = "create")
@AllArgsConstructor(staticName = "create")
@EqualsAndHashCode(of = "id")
@Builder
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    @Singular
    private Set<Role> roles;
}
