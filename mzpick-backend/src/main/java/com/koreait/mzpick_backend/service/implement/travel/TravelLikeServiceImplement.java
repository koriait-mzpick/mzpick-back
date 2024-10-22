package com.koreait.mzpick_backend.service.implement.travel;

import org.springframework.http.ResponseEntity;
<<<<<<< HEAD

import com.koreait.mzpick_backend.dto.response.ResponseDto;
=======
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.entity.travel.TravelLikeEntity;
import com.koreait.mzpick_backend.repository.travel.TravelLikeRepository;
import com.koreait.mzpick_backend.repository.travel.TravelRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
>>>>>>> 242a098102e96732941b60a9bb4018fddb37203b
import com.koreait.mzpick_backend.service.travel.TravelLikeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelLikeServiceImplement implements TravelLikeService {
<<<<<<< HEAD

    @Override
    public ResponseEntity<ResponseDto> getLike(Integer travelNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLIke'");
    }

    @Override
    public ResponseEntity<ResponseDto> postLike(String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postLIke'");
    }
    
=======
    private final TravelRepository travelRepository;
    private final UserRepository userRepository;
    private final TravelLikeRepository travelLikeRepository;

    @Override
    public ResponseEntity<ResponseDto> putLike(Integer travelNumber, String userId) {

        try {
            TravelEntity travelEntity = travelRepository.findByTravelNumber(travelNumber);
            if (travelEntity == null) return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser) return ResponseDto.noExistUserId();

            boolean isLike = travelLikeRepository.existsByUserIdAndTravelNumber(userId, travelNumber);

            TravelLikeEntity travelLikeEntity = new TravelLikeEntity(travelNumber, userId);

            if(isLike){
                travelLikeRepository.delete(travelLikeEntity);
                travelEntity.downLikeCount();
            }
            else{
                travelLikeRepository.save(travelLikeEntity);
                travelEntity.upLikeCount();
            }

            travelRepository.save(travelEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }
>>>>>>> 242a098102e96732941b60a9bb4018fddb37203b
}
