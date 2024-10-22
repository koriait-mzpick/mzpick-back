package com.koreait.mzpick_backend.repository.travel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.travel.TravelVoteEntity;

// Repository  여행지 투표 레포지토리//
@Repository
public interface TravelVoteRepository extends JpaRepository<TravelVoteEntity, Integer> {
    TravelVoteEntity findByTravelVoteNumber(Integer travelVoteNumber);
}
