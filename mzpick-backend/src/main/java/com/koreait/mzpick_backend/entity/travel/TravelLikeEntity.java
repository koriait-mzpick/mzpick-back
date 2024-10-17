package com.koreait.mzpick_backend.entity.travel;


import jakarta.persistence.Entity;
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
@Entity(name="travelLike")
@Table(name="travel_Like")
public class TravelLikeEntity {

    @Id
    private Integer travelNumber;
    @Id
    private String userId;
}