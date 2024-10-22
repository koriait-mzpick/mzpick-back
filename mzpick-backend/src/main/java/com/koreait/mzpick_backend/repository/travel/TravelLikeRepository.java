package com.koreait.mzpick_backend.repository.travel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.travel.TravelLikeEntity;
import com.koreait.mzpick_backend.entity.travel.TravelLikePK;

@Repository
public interface TravelLikeRepository extends JpaRepository<TravelLikeEntity, TravelLikePK> {
    boolean existsByUserIdAndTravelNumber(String userId, Integer travelNumber);
    List<TravelLikeEntity> findByTravelNumber(Integer travelNumber);
}
