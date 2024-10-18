package com.koreait.mzpick_backend.repository.fashion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.fashion.FashionEntity;

@Repository
public interface FashionRepository extends JpaRepository<FashionEntity, Integer> {
    
}
