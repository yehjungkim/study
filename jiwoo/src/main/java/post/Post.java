package post;

import board.Board;
import lombok.Builder;
import lombok.Getter;
import member.Member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name="POST")
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="POST_PK")
    private int post_pk;

    @ManyToOne
    @JoinColumn(name="SPORTS_CD_FK")
    private Board sports_cd_fk;

    @ManyToOne
    @JoinColumn(name="MEMBER_FK")
    private Member member_fk;

    @Column(name = "TITLE", nullable = false, length = 50)
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date create_ymd;

    @Temporal(TemporalType.TIMESTAMP)
    private Date update_ymd;

    @Column(name = "CONTENT", nullable = false)
    private String content;

    @Column(name = "VIEW_CNT", nullable = false)
    private int view_cnt;

    @Builder
    public Post(String title, Date create_ymd, Date update_ymd, String content) {
        this.title = title;
        this.content = content;
        this.create_ymd = create_ymd;
        this.update_ymd = update_ymd;
    }
}
