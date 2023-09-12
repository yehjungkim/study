package post;

import javax.validation.constraints.NotBlank;

public class ValidatePostRequestDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
