package br.com.course.ms.user.domain;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor(staticName = "create")
@AllArgsConstructor(staticName = "create")
@EqualsAndHashCode(of = "roleName")
@Builder
@Entity
@Table(name = "tb_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;
}
