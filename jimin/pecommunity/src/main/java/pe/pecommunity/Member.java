package pe.pecommunity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String nickname;
}
