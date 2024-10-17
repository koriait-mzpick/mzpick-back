package com.koreait.mzpick_backend.entity.stay;

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
    private String travelStayViewCount;
    private Date travelStayDate;
}
