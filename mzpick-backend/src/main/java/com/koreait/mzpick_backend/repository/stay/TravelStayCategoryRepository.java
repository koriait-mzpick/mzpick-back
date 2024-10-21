package com.koreait.mzpick_backend.repository.stay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.stay.TravelStayCategoryEntity;

import jakarta.transaction.Transactional;

import java.util.List;


@Repository
public interface TravelStayCategoryRepository extends JpaRepository<TravelStayCategoryEntity, Integer> {
    List<TravelStayCategoryEntity> findByTravelStayNumber(Integer travelStayNumber);
    
    @Transactional
    void deleteByTravelStayNumber(Integer travelStayNumber);
}
