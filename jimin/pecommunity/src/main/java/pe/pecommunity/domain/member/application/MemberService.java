package pe.pecommunity.domain.member.application;

import java.util.List;
import java.util.Optional;
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
        if(checkMemberId(member.getMemberId())) {
            throw new IllegalStateException(ErrorMessage.MEMBER_ID_ALREADY_EXIST);
        }

        if(checkNickname(member.getNickname())) {
            throw new IllegalStateException(ErrorMessage.NICKNAME_ALREADY_EXIST);
        }

        if(checkEmail(member.getEmail())) {
            throw new IllegalStateException(ErrorMessage.EMAIL_ALREADY_EXIST);
        }
    }

    public boolean checkMemberId(String memberId) {
        Optional<Member> findMember = memberRepository.findByMemberId(memberId);
        return findMember.isPresent();
    }

    private boolean checkNickname(String nickname) {
        Optional<Member> findMember = memberRepository.findByNickname(nickname);
        return findMember.isPresent();
    }

    private boolean checkEmail(String email) {
        Optional<Member> findMember = memberRepository.findByEmail(email);
        return findMember.isPresent();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
}
