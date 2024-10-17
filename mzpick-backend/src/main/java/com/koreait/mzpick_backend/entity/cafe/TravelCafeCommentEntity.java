package com.koreait.mzpick_backend.entity.cafe;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="travelCafeComment")
@Table(name="travel_cafe_comment")
public class TravelCafeCommentEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer travelCafeCommentNumber;
    private Integer travelCafeNumber;
    private String userId;
    private String travelCafeComment;
    
}
