package physical.education.yehjung.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "nick_name", columnDefinition = "VARCHAR(50) DEFAULT 'DefaultNickName'")
    private String nickName;
    @Column(name = "email")
    private String email;
    @Column(name = "pw")
    private String pw;

}
