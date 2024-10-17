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
@Entity(name="travelSave")
@Table(name="travel_save")
public class TravelSaveEntity {

    @Id
    private Integer travelNumber;
    @Id
    private String userId;
    
}