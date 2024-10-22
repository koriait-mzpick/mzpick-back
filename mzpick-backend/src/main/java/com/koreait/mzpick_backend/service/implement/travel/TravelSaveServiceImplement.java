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
@Service
@RequiredArgsConstructor
public class TravelSaveServiceImplement implements TravelSaveService {

    private final TravelRepository travelRepository;
    private final UserRepository userRepository;
    private final TravelSaveRepository travelSaveRepository;
    @Override
    public ResponseEntity<ResponseDto> putSave(Integer travelNumber, String userId) {
        try {
            TravelEntity travelEntity = travelRepository.findByTravelNumber(travelNumber);
            if (travelEntity == null) return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser) return ResponseDto.noExistUserId();

            boolean isLike = travelSaveRepository.existsByUserIdAndTravelNumber(userId, travelNumber);

            TravelSaveEntity travelSaveEntity = new TravelSaveEntity(travelNumber, userId);

            if (isLike) {
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
