package com.koreait.mzpick_backend.service.implement.food;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodLikeEntity;
import com.koreait.mzpick_backend.repository.food.TravelFoodLikeRepository;
import com.koreait.mzpick_backend.repository.food.TravelFoodRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.food.TravelFoodLikeService;
import lombok.RequiredArgsConstructor;

//service 해당 여행지 게시글 좋아요 서비스 //
@Service
@RequiredArgsConstructor
public class TravelFoodLikeServiceImplement implements TravelFoodLikeService {
    private final TravelFoodRepository travelFoodRepository;
    private final UserRepository userRepository;
    private final TravelFoodLikeRepository travelFoodLikeRepository;

    //put 해당 여행지 게시글 좋아요 누르기 및 좋아요 취소하기 서비스 //
    @Override
    public ResponseEntity<ResponseDto> putLike(Integer travelFoodNumber, String userId) {

        try {
            TravelFoodEntity travelFoodEntity = travelFoodRepository.findByTravelFoodNumber(travelFoodNumber);
            if (travelFoodEntity == null) return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser) return ResponseDto.noExistUserId();

            boolean isLike = travelFoodLikeRepository.existsByUserIdAndTravelFoodNumber(userId, travelFoodNumber);

            TravelFoodLikeEntity travelFoodLikeEntity = new TravelFoodLikeEntity(travelFoodNumber, userId);

            if(isLike){
                travelFoodLikeRepository.delete(travelFoodLikeEntity);
                travelFoodEntity.downLikeCount();
            }
            else{
                travelFoodLikeRepository.save(travelFoodLikeEntity);
                travelFoodEntity.upLikeCount();
            }

            travelFoodRepository.save(travelFoodEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }
}
