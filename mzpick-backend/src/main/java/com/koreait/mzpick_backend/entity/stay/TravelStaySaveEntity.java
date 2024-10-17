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
@Entity(name="travelStaySave")
@Table(name="travel_stay_save")
public class TravelStaySaveEntity {
    
    @Id
    private Integer travelStayNumber;
    @Id
    private String userId;
    
}
