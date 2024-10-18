package com.koreait.mzpick_backend.repository.cafe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeCategoryEntity;

@Repository
public interface TravelCafeCategoryRepository extends JpaRepository<TravelCafeCategoryEntity, Integer> {
    
}
