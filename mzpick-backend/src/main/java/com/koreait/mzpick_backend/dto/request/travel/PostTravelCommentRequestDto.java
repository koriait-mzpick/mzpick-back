package com.koreait.mzpick_backend.dto.request.travel;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostTravelCommentRequestDto {
    @NotBlank
    private String travelComment;
}
