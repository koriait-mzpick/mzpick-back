package com.koreait.mzpick_backend.repository.stay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.stay.TravelStaySaveEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStaySavepk;

@Repository
public interface TravelStaySaveRepository extends JpaRepository<TravelStaySaveEntity, TravelStaySavepk > {
    
}
