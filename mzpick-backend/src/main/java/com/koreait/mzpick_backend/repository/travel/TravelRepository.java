package com.koreait.mzpick_backend.repository.travel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.travel.TravelEntity;

@Repository
public interface TravelRepository extends JpaRepository<TravelEntity, Integer>{
    
    boolean existByTravelNumber(Integer TravelNumber);

    TravelEntity findByTravelNumber(Integer TravelNumber);
}
