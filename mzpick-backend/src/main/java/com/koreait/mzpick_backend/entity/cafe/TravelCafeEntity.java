package com.koreait.mzpick_backend.entity.cafe;

import java.util.Date;

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
@Entity(name="travelCafe")
@Table(name="travel_cafe")
public class TravelCafeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelCafeNumber;
    private String userId;
    private Integer travelCafeCategory;
    private String travelCafeTitle;
    private String travelLocation;
    private String travelCafeContent;
    private Integer travelCafeViewCount;
    private Date travelCafeDate;
}
