package com.koreait.mzpick_backend.repository.stay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.stay.TravelStayHashtagEntity;

@Repository
public interface TravelStayHashtagRepository extends JpaRepository<TravelStayHashtagEntity, Integer> {
    
}
