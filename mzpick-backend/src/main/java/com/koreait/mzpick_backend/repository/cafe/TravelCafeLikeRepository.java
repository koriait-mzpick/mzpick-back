package com.koreait.mzpick_backend.repository.cafe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeLikeEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeLikepk;

@Repository
public interface TravelCafeLikeRepository extends JpaRepository<TravelCafeLikeEntity, TravelCafeLikepk> {
    
}
