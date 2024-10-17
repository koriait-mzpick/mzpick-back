package com.koreait.mzpick_backend.entity.stay;


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
@Entity(name="travelStayLike")
@Table(name="travel_stay_like")
public class TravelStayLikeEntity {
    
    @Id
    private Integer travelStayNumber;
    @Id
    private String userId;
    
}
