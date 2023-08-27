package pe.pecommunity.domain.member.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.pecommunity.domain.member.domain.Member;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public Optional<Member> findByMemberId(String memberId) {
        List<Member> member = em.createQuery("select m from Member m where m.memberId = :memberId", Member.class)
                .setParameter("memberId", memberId)
                .getResultList();
        return member.stream().findAny();
    }

    public Optional<Member> findByNickname(String nickname) {
        List<Member> member =  em.createQuery("select m from Member m where m.nickname = :nickname", Member.class)
                .setParameter("nickname", nickname)
                .getResultList();
        return member.stream().findAny();
    }

    public Optional<Member> findByEmail(String email) {
        List<Member> member =  em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getResultList();
        return member.stream().findAny();
    }
}
