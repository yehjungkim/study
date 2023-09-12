package physical.education.yehjung.board.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postPk;

    private int sportsCdFk;

    private String memberFk;

    private String title;

    private String createYmd;

    private String updateYmd;

    private String content;

    private String viewCnt;

    @Builder
    public Post(int postPk ,int sportsCdFk,String memberFk,String title,String createYmd,String updateYmd,String content,String viewCnt)
    {
        this.postPk = postPk;
        this.sportsCdFk = sportsCdFk;
        this.memberFk = memberFk;
        this.title = title;
        this.createYmd = createYmd;
        this.updateYmd = updateYmd;
        this.content = content;
        this.viewCnt = viewCnt;

    }

}
