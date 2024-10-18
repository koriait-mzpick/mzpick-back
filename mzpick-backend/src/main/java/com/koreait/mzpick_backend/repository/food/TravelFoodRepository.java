package com.koreait.mzpick_backend.repository.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;

@Repository
public interface TravelFoodRepository extends JpaRepository<TravelFoodEntity, Integer> {
    
}
