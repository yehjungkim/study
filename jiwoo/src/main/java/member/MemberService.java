package member;

public interface MemberService {

    //회원 가입
    void join(Member member);

    Member login(String id, String pw);
}
