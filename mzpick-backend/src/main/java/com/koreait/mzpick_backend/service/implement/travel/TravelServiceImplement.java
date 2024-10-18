package com.koreait.mzpick_backend.service.implement.travel;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.repository.travel.TravelRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.travel.TravelService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelServiceImplement implements TravelService{
    private UserRepository userRepository;
    private TravelRepository travelRepository;

    @Override
    public ResponseEntity<ResponseDto> travelFavorite(Integer travelNumber, String userId) {

        try {
            TravelEntity travelEntity = travelRepository.findByTravelNumber(travelNumber);
            if(travelEntity == null) return ResponseDto.noExistBoard();

            boolean existeUserId = userRepository.existsByUserId(userId);
            if(!existeUserId) return ResponseDto.noExistUserId();



        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }
    
}
