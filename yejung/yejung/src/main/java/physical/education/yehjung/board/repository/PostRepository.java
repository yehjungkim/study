package physical.education.yehjung.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import physical.education.yehjung.board.dto.Post;

public interface PostRepository extends JpaRepository<Post,Long> {
}
