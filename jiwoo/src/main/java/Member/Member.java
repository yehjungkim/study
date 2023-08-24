package Member;

import java.util.Date;

public class Member {

    private int member_pk;
    private int auth_cd_pk;
    private String nickname;
    private String id;
    private String pw;
    private String email;
    private Date dormant_account_YMD;

    public Member(int member_pk, int auth_cd_pk, String nickname, String id, String pw, String email, Date dormant_account_YMD) {
        this.member_pk = member_pk;
        this.auth_cd_pk = auth_cd_pk;
        this.nickname = nickname;
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.dormant_account_YMD = dormant_account_YMD;
    }

    public int getMember_pk() {
        return member_pk;
    }

    public void setMember_pk(int member_pk) {
        this.member_pk = member_pk;
    }

    public int getAuth_cd_pk() {
        return auth_cd_pk;
    }

    public void setAuth_cd_pk(int auth_cd_pk) {
        this.auth_cd_pk = auth_cd_pk;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDormant_account_YMD() {
        return dormant_account_YMD;
    }

    public void setDormant_account_YMD(Date dormant_account_YMD) {
        this.dormant_account_YMD = dormant_account_YMD;
    }

}

