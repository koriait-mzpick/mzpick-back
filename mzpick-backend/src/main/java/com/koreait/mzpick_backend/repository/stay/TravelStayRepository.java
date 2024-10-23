package com.koreait.mzpick_backend.repository.stay;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;


@Repository
public interface TravelStayRepository extends JpaRepository<TravelStayEntity, Integer> {
    TravelStayEntity findByTravelStayNumber(Integer travelStayNumber);

     // ! 5개의 게시글 을 출력하고 Param을 이용한 페이지네이션 구현 //
    @Query(value=
    "SELECT * FROM travel_stay " +
    "ORDER BY travel_date DESC " + 
    "LIMIT :paging, 5", 
    nativeQuery=true)
    List<TravelStayEntity> findByPaging(@Param("paging") Integer paging);
}
