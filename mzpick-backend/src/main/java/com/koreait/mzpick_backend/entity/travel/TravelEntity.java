package com.koreait.mzpick_backend.entity.travel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelRequestDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="travel")
@Table(name="travel")
public class TravelEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelNumber;
    private String userId;
    private String travelTitle;
    private String travelLocation;
    private String travelContent;
    private Integer travelViewCount;
    private LocalDate travelDate;

    public TravelEntity(PostTravelRequestDto dto, String userId){
        this.userId = userId;
        this.travelTitle = dto.getTravelTitle();
        this.travelLocation = dto.getTravelLocation();
        this.travelContent = dto.getTravelContent();
        this.travelDate = LocalDate.now();
        this.travelViewCount = 0;
    }
}