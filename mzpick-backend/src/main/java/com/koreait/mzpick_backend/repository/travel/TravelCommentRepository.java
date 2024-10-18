package com.koreait.mzpick_backend.repository.travel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.travel.TravelCommentEntity;

@Repository
public interface TravelCommentRepository extends JpaRepository<TravelCommentEntity, Integer>{
    
}
