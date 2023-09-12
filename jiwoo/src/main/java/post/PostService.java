package post;

public interface PostService {

    void enrollPost(ValidatePostRequestDto validatePostRequestDto);

    void deletePost(long post_pk);
}
