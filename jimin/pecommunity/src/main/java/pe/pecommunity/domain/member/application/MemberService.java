package pe.pecommunity.domain.member.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.pecommunity.domain.member.dao.MemberRepository;
import pe.pecommunity.domain.member.domain.Member;
import pe.pecommunity.global.error.ErrorMessage;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByMemberId(member.getMemberId());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException(ErrorMessage.MEMBER_ID_ALREADY_EXIST);
        }

        findMembers = memberRepository.findByNickname(member.getNickname());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException(ErrorMessage.NICKNAME_ALREADY_EXIST);
        }

        findMembers = memberRepository.findByEmail(member.getEmail());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException(ErrorMessage.EMAIL_ALREADY_EXIST);
        }
    }
}
