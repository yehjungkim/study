package pe.pecommunity.domain.member.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_pk")
    private Long id;

    @Column(unique = true, nullable = false)
    private String memberId;

    @Column(unique = true, nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    private LocalDateTime dormantConversionDate;
}
