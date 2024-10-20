package com.koreait.mzpick_backend.entity.travel;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="travelPhoto")
@Table(name="travel_photo")
public class TravelPhotoEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelPhotoNumber;
    

    @ManyToOne
    @JoinColumn(name = "travel_number")
    private Integer travelNumber;
    private String travelPhotoLink;

    @Builder
    public TravelPhotoEntity
}