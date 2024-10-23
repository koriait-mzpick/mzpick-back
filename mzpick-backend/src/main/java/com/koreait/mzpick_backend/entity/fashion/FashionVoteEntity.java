package com.koreait.mzpick_backend.entity.fashion;

import java.time.LocalDate;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelVoteRequestDto;

import jakarta.persistence.Column;
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
@Entity(name="fashionVote")
@Table(name="fashion_vote")
public class FashionVoteEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer fashionVoteNumber;
    private String userId;
    private String fashionVoteTitle;
    @Column(name="fashion_vote_photo_1")
    private String fashionVotePhoto1;
    @Column(name="fashion_vote_photo_2")
    private String fashionVotePhoto2;
    @Column(name="fashion_vote_choice_1")
    private String fashionVoteChoice1;
    @Column(name="fashion_vote_choice_2")
    private String fashionVoteChoice2;
    private LocalDate fashionVoteDate;

    public FashionVoteEntity(PostTravelVoteRequestDto dto, String userId){
        this.userId = userId;
        this.fashionVoteTitle = dto.getTravelVoteTitle();
        this.fashionVotePhoto1 = dto.getTravelVotePhoto1();
        this.fashionVotePhoto2 = dto.getTravelVotePhoto2();
        this.fashionVoteChoice1 = dto.getTravelVoteChoice1();
        this.fashionVoteChoice2 = dto.getTravelVoteChoice2();
        this.fashionVoteDate = LocalDate.now();
    }
}
