package com.koreait.mzpick_backend.service.implement.food;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodSaveEntity;
import com.koreait.mzpick_backend.repository.food.TravelFoodRepository;
import com.koreait.mzpick_backend.repository.food.TravelFoodSaveRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.food.TravelFoodSaveService;

import lombok.RequiredArgsConstructor;

//service 해당 여행지 관련 게시글 저장하기 //
@Service
@RequiredArgsConstructor
public class TravelFoodSaveFoodServiceImplement implements TravelFoodSaveService {

    private final TravelFoodRepository travelFoodRepository;
    private final UserRepository userRepository;
    private final TravelFoodSaveRepository travelFoodSaveRepository;

    //put 해당 여행지 게시글 저장하기 및 저장 취소하기 서비스 //
    @Override
    public ResponseEntity<ResponseDto> putSave(Integer travelFoodNumber, String userId) {
        try {
            TravelFoodEntity travelFoodEntity = travelFoodRepository.findByTravelFoodNumber(travelFoodNumber);
            if (travelFoodEntity == null) return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser) return ResponseDto.noExistUserId();

            boolean isSave = travelFoodSaveRepository.existsByUserIdAndTravelFoodNumber(userId, travelFoodNumber);

            TravelFoodSaveEntity travelFoodSaveEntity = new TravelFoodSaveEntity(travelFoodNumber, userId);

            if (isSave) {
                travelFoodSaveRepository.delete(travelFoodSaveEntity);
            } else {
                travelFoodSaveRepository.save(travelFoodSaveEntity);
            }

            travelFoodRepository.save(travelFoodEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

}
