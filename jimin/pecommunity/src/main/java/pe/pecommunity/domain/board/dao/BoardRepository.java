package pe.pecommunity.domain.board.dao;

import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.pecommunity.domain.board.domain.Board;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public void save(Board board) {
        em.persist(board);
    }

    public Board findOne(Long id) {
        return em.find(Board.class, id);
    }
}
