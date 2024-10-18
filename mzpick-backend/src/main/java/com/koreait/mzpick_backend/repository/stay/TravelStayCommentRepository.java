package com.koreait.mzpick_backend.repository.stay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.stay.TravelStayCommentEntity;


@Repository
public interface TravelStayCommentRepository extends JpaRepository<TravelStayCommentEntity, Integer> {
    
}
