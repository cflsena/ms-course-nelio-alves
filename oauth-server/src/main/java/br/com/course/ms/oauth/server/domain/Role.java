package br.com.course.ms.oauth.server.domain;

import lombok.*;

@Data
@NoArgsConstructor(staticName = "create")
@AllArgsConstructor(staticName = "create")
@EqualsAndHashCode(of = "roleName")
@Builder
public class Role {
    private Long id;
    private String roleName;
}
