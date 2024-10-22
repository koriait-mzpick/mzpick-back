package com.koreait.mzpick_backend.repository.travel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.travel.TravelCommentEntity;

import jakarta.transaction.Transactional;

@Repository
public interface TravelCommentRepository extends JpaRepository<TravelCommentEntity, Integer>{
    TravelCommentEntity findByTravelCommentNumber(Integer travelCommentNumber);
    TravelCommentEntity findByTravelCommentNumberAndTravelNumber(Integer travelNumber, Integer travelCommentNumber);
    
    @Transactional
    void deleteByTravelNumber(Integer travelNumber);

    @Transactional
    void deleteByTravelCommentNumber(Integer travelCommentNumber);
}
