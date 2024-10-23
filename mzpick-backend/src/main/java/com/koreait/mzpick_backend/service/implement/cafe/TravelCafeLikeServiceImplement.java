package com.koreait.mzpick_backend.service.implement.cafe;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeLikeEntity;
import com.koreait.mzpick_backend.repository.cafe.TravelCafeLikeRepository;
import com.koreait.mzpick_backend.repository.cafe.TravelCafeRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.cafe.TravelCafeLikeService;

import lombok.RequiredArgsConstructor;

//service 해당 여행지 게시글 좋아요 서비스 //
@Service
@RequiredArgsConstructor
public class TravelCafeLikeServiceImplement implements TravelCafeLikeService {
    private final TravelCafeRepository travelCafeRepository;
    private final UserRepository userRepository;
    private final TravelCafeLikeRepository travelCafeLikeRepository;

    //put 해당 여행지 게시글 좋아요 누르기 및 좋아요 취소하기 서비스 //
    @Override
    public ResponseEntity<ResponseDto> putLike(Integer travelCafeNumber, String userId) {

        try {
            TravelCafeEntity travelCafeEntity = travelCafeRepository.findByTravelCafeNumber(travelCafeNumber);
            if (travelCafeEntity == null) return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser) return ResponseDto.noExistUserId();

            boolean isLike = travelCafeLikeRepository.existsByUserIdAndTravelCafeNumber(userId, travelCafeNumber);

            TravelCafeLikeEntity travelCafeLikeEntity = new TravelCafeLikeEntity(travelCafeNumber, userId);

            if(isLike){
                travelCafeLikeRepository.delete(travelCafeLikeEntity);
                travelCafeEntity.downLikeCount();
            }
            else{
                travelCafeLikeRepository.save(travelCafeLikeEntity);
                travelCafeEntity.upLikeCount();
            }

            travelCafeRepository.save(travelCafeEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }
}
