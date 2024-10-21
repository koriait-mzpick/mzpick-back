package com.koreait.mzpick_backend.entity.travel;


import java.util.List;
import java.util.ArrayList;

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
@Entity(name="travelHashtag")
@Table(name="travel_hashtag")
public class TravelHashtagEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelHashtagNumber;
    private Integer travelNumber;
    private String travelHashtagContent;

    public TravelHashtagEntity(Integer travelNumber, String travelHashtagContent) {
        this.travelNumber = travelNumber;
        this.travelHashtagContent = travelHashtagContent;
    }

    public void patch(Integer travelNumber, String travelHashtagContent){
        this.travelNumber = travelNumber;
        this.travelHashtagContent =travelHashtagContent;
    }
    
}