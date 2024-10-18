package com.koreait.mzpick_backend.dto.request.cafe;
// 여행지 리스트 보기 요청 dto

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchTravelCafeRequestDto {
    @NotBlank
    private String travelCafeTitle;
    @NotNull
    private List<String> travelCafeHashtagContent;
    @NotBlank
    private String travelCafeLocation;
    @NotNull
    private List<String> travelCafePhoto;
    @NotNull
    private List<String> travelCafeCategoryList;
    @NotBlank
    private String travelCafeContent;
}