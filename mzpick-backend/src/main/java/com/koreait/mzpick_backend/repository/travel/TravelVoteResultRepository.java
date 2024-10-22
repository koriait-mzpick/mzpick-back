package com.koreait.mzpick_backend.repository.travel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.travel.TravelVoteResultEntity;
import com.koreait.mzpick_backend.entity.travel.TravelVoteResultPK;

// Repository 여행지 투표 결과 //
@Repository
public interface TravelVoteResultRepository extends JpaRepository<TravelVoteResultEntity, TravelVoteResultPK>{
    List<TravelVoteResultEntity> findByTravelVoteNumber(Integer travelVoteNumber);

    boolean existsByUserIdAndTravelVoteNumber(String userId, Integer travelVoteNumber);
}
