package com.koreait.mzpick_backend.entity.travel;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TravelSavePK implements Serializable{
    @Column()
    private Integer travelNumber;
    @Column()
    private String userId;
    
}
