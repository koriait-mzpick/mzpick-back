package com.koreait.mzpick_backend.repository.travel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.travel.TravelVoteResultEntity;
import com.koreait.mzpick_backend.entity.travel.TravelVoteResultPK;

@Repository
public interface TravelVoteResultRepository extends JpaRepository<TravelVoteResultEntity, TravelVoteResultPK>{
    
}
