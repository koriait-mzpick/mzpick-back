package com.koreait.mzpick_backend.entity.stay;

import java.time.LocalDate;
import java.util.Date;

import com.koreait.mzpick_backend.dto.request.food.PostTravelFoodRequestDto;
import com.koreait.mzpick_backend.dto.request.stay.PatchTravelStayRequestDto;
import com.koreait.mzpick_backend.dto.request.stay.PostTravelStayRequestDto;
import com.koreait.mzpick_backend.dto.request.travel.PatchTravelRequestDto;
import com.koreait.mzpick_backend.dto.request.travel.PostTravelRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="travelStay")
@Table(name="travel_stay")
public class TravelStayEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelStayNumber;
    private String userId;
    private String travelStayTitle;
    private String travelLocation;
    private String travelStayContent;
    private Integer travelStayViewCount;
    private LocalDate travelStayDate;

        public TravelStayEntity(PostTravelStayRequestDto dto, String userId){
        this.userId = userId;
        this.travelStayTitle = dto.getTravelStayTitle();
        this.travelLocation = dto.getTravelStayLocation();
        this.travelStayContent = dto.getTravelStayContent();
        this.travelStayDate = LocalDate.now();
        this.travelStayViewCount = 0;
    }

    public void patch(PatchTravelStayRequestDto dto, String userId){
        this.userId = userId;
        this.travelStayTitle = dto.getTravelStayTitle();
        this.travelLocation = dto.getTravelStayLocation();
        this.travelStayContent = dto.getTravelStayContent();
        this.travelStayDate = LocalDate.now();
    }
}
