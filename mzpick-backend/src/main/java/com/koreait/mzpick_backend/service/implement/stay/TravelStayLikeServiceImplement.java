package com.koreait.mzpick_backend.service.implement.stay;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayLikeEntity;
import com.koreait.mzpick_backend.repository.stay.TravelStayLikeRepository;
import com.koreait.mzpick_backend.repository.stay.TravelStayRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.stay.TravelStayLikeService;

import lombok.RequiredArgsConstructor;

//service 해당 여행지 게시글 좋아요 서비스 //
@Service
@RequiredArgsConstructor
public class TravelStayLikeServiceImplement implements TravelStayLikeService {
    private final TravelStayRepository travelStayRepository;
    private final UserRepository userRepository;
    private final TravelStayLikeRepository travelStayLikeRepository;

    //put 해당 여행지 게시글 좋아요 누르기 및 좋아요 취소하기 서비스 //
    @Override
    public ResponseEntity<ResponseDto> putLike(Integer travelStayNumber, String userId) {

        try {
            TravelStayEntity travelStayEntity = travelStayRepository.findByTravelStayNumber(travelStayNumber);
            if (travelStayEntity == null) return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser) return ResponseDto.noExistUserId();

            boolean isLike = travelStayLikeRepository.existsByUserIdAndTravelStayNumber(userId, travelStayNumber);

            TravelStayLikeEntity travelStayLikeEntity = new TravelStayLikeEntity(travelStayNumber, userId);

            if(isLike){
                travelStayLikeRepository.delete(travelStayLikeEntity);
                travelStayEntity.downLikeCount();
            }
            else{
                travelStayLikeRepository.save(travelStayLikeEntity);
                travelStayEntity.upLikeCount();
            }

            travelStayRepository.save(travelStayEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }
}
