package com.koreait.mzpick_backend.entity.travel;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="travelVoteResult")
@Table(name="travel_vote_result")
@IdClass(TravelVoteResultPK.class)
public class TravelVoteResultEntity {

    @Id
    private Integer travelVoteNumber;
    @Id
    private String userId;
    private String travelVoteResultChoice;
}