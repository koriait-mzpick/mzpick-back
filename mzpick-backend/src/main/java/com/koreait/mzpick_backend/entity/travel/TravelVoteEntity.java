package com.koreait.mzpick_backend.entity.travel;

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
@Entity(name="travelVote")
@Table(name="travel_vote")
public class TravelVoteEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelVoteNumber;
    private String userId;
    private String travelVoteTitle;
    private String travelVotePhoto1;
    private String travelVotePhoto2;
    private String travelVoteChoice1;
    private String travelVoteChoice2;
    private Date travelVoteDate;
}
