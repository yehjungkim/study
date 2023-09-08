package pe.pecommunity.domain.post.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.pecommunity.domain.board.dao.BoardRepository;
import pe.pecommunity.domain.board.domain.Board;
import pe.pecommunity.domain.member.dao.MemberRepository;
import pe.pecommunity.domain.member.domain.Member;
import pe.pecommunity.domain.post.dao.PostRepository;
import pe.pecommunity.domain.post.domain.Post;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    /**
     * 게시글 등록
     */
    @Transactional
    public Long resister(Long memberId, Long boardId, String title, String content) {

        // 엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Board board = boardRepository.findOne(boardId);

        // 게시글 생성
        Post post = Post.createPostBuilder()
                .member(member)
                .board(board)
                .title(title)
                .content(content)
                .build();

        postRepository.save(post);

        return post.getId();
    }
}
