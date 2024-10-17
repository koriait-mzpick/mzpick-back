package com.koreait.mzpick_backend.entity.cafe;


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
@Entity(name="travelCafeSae")
@Table(name="travel_cafe_save")
public class TravelCafeSaveEntity {
    @Id
    private Integer travelCafeNumber;
    @Id
    private String userId;
    
}
