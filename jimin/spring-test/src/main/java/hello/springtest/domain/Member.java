package hello.springtest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String nickname;

    private String password;

    @Column(unique = true)
    private String email;

    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
    }
}
