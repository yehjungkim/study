package pe.pecommunity.domain.post.application;

import static pe.pecommunity.global.error.ErrorCode.BOARD_NOT_EXIST;
import static pe.pecommunity.global.error.ErrorCode.MEMBER_NOT_EXIST;

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
import pe.pecommunity.domain.post.dto.PostRequestDto;
import pe.pecommunity.global.error.exception.BaseException;

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
    public Long resister(PostRequestDto postRequest) {

        // 엔티티 조회
        Member member = memberRepository.findById(postRequest.getMemberId())
                .orElseThrow(() -> new BaseException(MEMBER_NOT_EXIST));
        Board board = boardRepository.findById(postRequest.getBoardId())
                .orElseThrow(() -> new BaseException(BOARD_NOT_EXIST));

        // 게시글 생성
        Post post = Post.createPostBuilder()
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .member(member)
                .board(board)
                .build();

        postRepository.save(post);

        return post.getId();
    }
}
