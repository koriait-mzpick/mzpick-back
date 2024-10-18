package com.koreait.mzpick_backend.repository.cafe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeSaveEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeSavepk;

@Repository
public interface TravelCafeSaveRepository extends JpaRepository<TravelCafeSaveEntity, TravelCafeSavepk> {
    
}
