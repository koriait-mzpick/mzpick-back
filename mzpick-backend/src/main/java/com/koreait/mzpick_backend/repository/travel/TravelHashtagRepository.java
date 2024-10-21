package com.koreait.mzpick_backend.repository.travel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.travel.TravelHashtagEntity;

import jakarta.transaction.Transactional;

@Repository
public interface TravelHashtagRepository extends JpaRepository<TravelHashtagEntity, Integer> {
    TravelHashtagEntity findByTravelNumber(Integer travelNumber);


    @Transactional
    void deleteByTravelNumber(Integer travelNumber);
}
