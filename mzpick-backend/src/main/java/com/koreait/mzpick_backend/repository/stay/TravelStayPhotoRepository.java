package com.koreait.mzpick_backend.repository.stay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.stay.TravelStayPhotoEntity;

@Repository
public interface TravelStayPhotoRepository extends JpaRepository<TravelStayPhotoEntity, Integer> {
    
}
