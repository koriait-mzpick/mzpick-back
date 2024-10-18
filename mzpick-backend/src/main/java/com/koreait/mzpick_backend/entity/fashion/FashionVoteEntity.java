package com.koreait.mzpick_backend.entity.fashion;

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
@Entity(name="fashionVote")
@Table(name="fashion_vote")
public class FashionVoteEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer fashionVoteNumber;
    private String userId;
    private String fashionVoteTitle;
    private String fashionVotePhoto1;
    private String fashionVotePhoto2;
    private String fashionVoteChoice1;
    private String fashionVoteChoice2;
    private Date fashionVoteDate;
}
