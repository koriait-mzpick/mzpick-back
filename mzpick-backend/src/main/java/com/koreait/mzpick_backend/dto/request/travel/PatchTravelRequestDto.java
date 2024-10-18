package com.koreait.mzpick_backend.dto.request.travel;
// 여행지 리스트 보기 요청 dto

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchTravelRequestDto {
    @NotBlank
    private String travelTitle;
    @NotBlank
    private List<String> travelHashtagContentList;
    @NotBlank
    private String travelLocation;
    @NotBlank
    private List<String> travelPhotoList;
    @NotBlank
    private String travelContent;
}
