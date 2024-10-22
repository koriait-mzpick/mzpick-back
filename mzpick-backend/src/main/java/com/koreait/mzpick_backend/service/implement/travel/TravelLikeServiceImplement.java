package com.koreait.mzpick_backend.service.implement.travel;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.entity.travel.TravelLikeEntity;
import com.koreait.mzpick_backend.repository.travel.TravelLikeRepository;
import com.koreait.mzpick_backend.repository.travel.TravelRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.travel.TravelLikeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelLikeServiceImplement implements TravelLikeService {
    private final TravelRepository travelRepository;
    private final UserRepository userRepository;
    private final TravelLikeRepository travelLikeRepository;

    @Override
    public ResponseEntity<ResponseDto> postLike(Integer travelNumber, String userId) {

        try {
            TravelEntity travelEntity = travelRepository.findByTravelNumber(travelNumber);
            if (travelEntity == null) return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser) return ResponseDto.noExistUserId();

            boolean isLike = travelLikeRepository.existsByUserIdAndTravelNumber(userId, travelNumber);

            TravelLikeEntity travelLikeEntity = new TravelLikeEntity(travelNumber, userId);

            if(isLike){
                travelLikeRepository.delete(travelLikeEntity);
            }
            else{
                travelLikeRepository.save(travelLikeEntity);
            }

            travelRepository.save(travelEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }
}
