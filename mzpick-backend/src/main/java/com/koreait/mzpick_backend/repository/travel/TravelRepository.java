package com.koreait.mzpick_backend.repository.travel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.travel.TravelEntity;

@Repository
public interface TravelRepository extends JpaRepository<TravelEntity, Integer>{
    TravelEntity findByTravelNumber(Integer travelNumber);


    @Query(value=
    "SELECT * FROM travel " +
    "ORDER BY travel_date DESC " + 
    "LIMIT :paging, 5", 
    nativeQuery=true)
    List<TravelEntity> findByPaging(@Param("paging") Integer paging);

}
