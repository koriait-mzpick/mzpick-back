package com.koreait.mzpick_backend.repository.travel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.travel.TravelPhotoEntity;

import jakarta.transaction.Transactional;


@Repository
public interface TravelPhotoRepository extends JpaRepository<TravelPhotoEntity, Integer> {
    
    List<TravelPhotoEntity> findByTravelNumber(Integer travelNumber);
    
    @Transactional
    void deleteByTravelNumber(Integer travelNumber);
}
