package com.koreait.mzpick_backend.repository.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.food.TravelFoodCommentEntity;

@Repository
public interface TravelFoodCommentRepository extends JpaRepository<TravelFoodCommentEntity, Integer> {
    
}
