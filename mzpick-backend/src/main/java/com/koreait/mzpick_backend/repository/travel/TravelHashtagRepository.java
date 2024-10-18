package com.koreait.mzpick_backend.repository.travel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.travel.TravelHashtagEntity;

@Repository
public interface TravelHashtagRepository extends JpaRepository<TravelHashtagEntity, Integer> {
    
}
