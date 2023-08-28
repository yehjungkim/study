package Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Integer, Member> memberList = new HashMap<>();

    @Override
    public void saveMember(Member member) {
        memberList.put(Integer.valueOf(member.getMember_pk()), member);
    }

}
