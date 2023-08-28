package Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="MEMBER", uniqueConstraints = {@UniqueConstraint(
        name = "ID_EMAIL_UNIQUE",
        columnNames = {"ID","EMAIL"}
)})
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="MEMBER_PK")
    private long member_pk;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Column(name="NICKNAME", nullable = false, length = 10)
    private String nickname;


    @Column(name = "ID", nullable = false, length = 10)
    private String id;


    @Column(name = "PW", nullable = false, length = 15)
    private String pw;

    @Column(name = "EMAIL", nullable = false, length = 30)
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
     private Date dormant_account_YMD;

    public Member(String nickname, String id, String pw, String email) {
        this.nickname = nickname;
        this.id = id;
        this.pw = pw;
        this.email = email;
    }

    public Member createMember(SignUpRequestDto signUpDto) {
        Member member = new Member();
        member.setAuthority(Authority.MEMBER);
        member.setNickname(signUpDto.getNickname());
        member.setId(signUpDto.getId());
        member.setPw(signUpDto.getPw());
        member.setEmail(signUpDto.getEmail());
        return member;
    }

}

