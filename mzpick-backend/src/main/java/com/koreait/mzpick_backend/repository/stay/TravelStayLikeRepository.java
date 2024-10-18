package com.koreait.mzpick_backend.repository.stay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.stay.TravelStayLikeEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayLikepk;

@Repository
public interface TravelStayLikeRepository extends JpaRepository<TravelStayLikeEntity, TravelStayLikepk> {
    
}
