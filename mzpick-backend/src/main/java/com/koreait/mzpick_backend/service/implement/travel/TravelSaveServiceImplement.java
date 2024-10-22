package com.koreait.mzpick_backend.service.implement.travel;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.entity.travel.TravelSaveEntity;
import com.koreait.mzpick_backend.repository.travel.TravelRepository;
import com.koreait.mzpick_backend.repository.travel.TravelSaveRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.travel.TravelSaveService;

import lombok.RequiredArgsConstructor;

//service 해당 여행지 관련 게시글 저장하기 //
@Service
@RequiredArgsConstructor
public class TravelSaveServiceImplement implements TravelSaveService {

    private final TravelRepository travelRepository;
    private final UserRepository userRepository;
    private final TravelSaveRepository travelSaveRepository;

    //put 해당 여행지 게시글 저장하기 및 저장 취소하기 서비스 //
    @Override
    public ResponseEntity<ResponseDto> putSave(Integer travelNumber, String userId) {
        try {
            TravelEntity travelEntity = travelRepository.findByTravelNumber(travelNumber);
            if (travelEntity == null) return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser) return ResponseDto.noExistUserId();

            boolean isSave = travelSaveRepository.existsByUserIdAndTravelNumber(userId, travelNumber);

            TravelSaveEntity travelSaveEntity = new TravelSaveEntity(travelNumber, userId);

            if (isSave) {
                travelSaveRepository.delete(travelSaveEntity);
            } else {
                travelSaveRepository.save(travelSaveEntity);
            }

            travelRepository.save(travelEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

}
