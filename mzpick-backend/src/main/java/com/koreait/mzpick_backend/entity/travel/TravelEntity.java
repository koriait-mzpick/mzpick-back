package com.koreait.mzpick_backend.entity.travel;

import java.util.Date;

import jakarta.persistence.Entity;
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

    private Integer travelNumber;
    private String userId;
    private String travelTitle;
    private String travelLocation;
    private String travelContent;
    private Integer travelViewCount;
    private Date travelDate;
}