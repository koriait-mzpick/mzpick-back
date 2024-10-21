package com.koreait.mzpick_backend.repository.stay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;


@Repository
public interface TravelStayRepository extends JpaRepository<TravelStayEntity, Integer> {
    TravelStayEntity findByTravelStayNumber(Integer travelStayNumber);
}
