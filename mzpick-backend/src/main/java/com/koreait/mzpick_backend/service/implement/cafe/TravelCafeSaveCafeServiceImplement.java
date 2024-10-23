package com.koreait.mzpick_backend.service.implement.cafe;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeSaveEntity;
import com.koreait.mzpick_backend.repository.cafe.TravelCafeRepository;
import com.koreait.mzpick_backend.repository.cafe.TravelCafeSaveRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.cafe.TravelCafeSaveService;

import lombok.RequiredArgsConstructor;

//service 해당 여행지 관련 게시글 저장하기 //
@Service
@RequiredArgsConstructor
public class TravelCafeSaveCafeServiceImplement implements TravelCafeSaveService {

    private final TravelCafeRepository travelCafeRepository;
    private final UserRepository userRepository;
    private final TravelCafeSaveRepository travelCafeSaveRepository;

    //put 해당 여행지 게시글 저장하기 및 저장 취소하기 서비스 //
    @Override
    public ResponseEntity<ResponseDto> putSave(Integer travelCafeNumber, String userId) {
        try {
            TravelCafeEntity travelCafeEntity = travelCafeRepository.findByTravelCafeNumber(travelCafeNumber);
            if (travelCafeEntity == null) return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser) return ResponseDto.noExistUserId();

            boolean isSave = travelCafeSaveRepository.existsByUserIdAndTravelCafeNumber(userId, travelCafeNumber);

            TravelCafeSaveEntity travelCafeSaveEntity = new TravelCafeSaveEntity(travelCafeNumber, userId);

            if (isSave) {
                travelCafeSaveRepository.delete(travelCafeSaveEntity);
            } else {
                travelCafeSaveRepository.save(travelCafeSaveEntity);
            }

            travelCafeRepository.save(travelCafeEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

}
