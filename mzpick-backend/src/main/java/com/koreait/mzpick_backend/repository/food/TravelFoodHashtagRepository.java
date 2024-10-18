package com.koreait.mzpick_backend.repository.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.food.TravelFoodHashtagEntity;

@Repository
public interface TravelFoodHashtagRepository extends JpaRepository<TravelFoodHashtagEntity, Integer> {
    
}
