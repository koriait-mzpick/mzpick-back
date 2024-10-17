package com.koreait.mzpick_backend.entity.food;


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
@Entity(name="travelFoodLike")
@Table(name="travel_food_like")
public class TravelFoodLikeEntity {

    @Id
    private Integer travelFoodNumber;
    @Id
    private String userId;
}