package com.koreait.mzpick_backend.service.implement.stay;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStaySaveEntity;
import com.koreait.mzpick_backend.repository.stay.TravelStayRepository;
import com.koreait.mzpick_backend.repository.stay.TravelStaySaveRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.stay.TravelStaySaveService;

import lombok.RequiredArgsConstructor;

//service 해당 여행지 관련 게시글 저장하기 //
@Service
@RequiredArgsConstructor
public class TravelStaySaveStayServiceImplement implements TravelStaySaveService {

    private final TravelStayRepository travelStayRepository;
    private final UserRepository userRepository;
    private final TravelStaySaveRepository travelStaySaveRepository;

    //put 해당 여행지 게시글 저장하기 및 저장 취소하기 서비스 //
    @Override
    public ResponseEntity<ResponseDto> putSave(Integer travelStayNumber, String userId) {
        try {
            TravelStayEntity travelStayEntity = travelStayRepository.findByTravelStayNumber(travelStayNumber);
            if (travelStayEntity == null) return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser) return ResponseDto.noExistUserId();

            boolean isSave = travelStaySaveRepository.existsByUserIdAndTravelStayNumber(userId, travelStayNumber);

            TravelStaySaveEntity travelStaySaveEntity = new TravelStaySaveEntity(travelStayNumber, userId);

            if (isSave) {
                travelStaySaveRepository.delete(travelStaySaveEntity);
            } else {
                travelStaySaveRepository.save(travelStaySaveEntity);
            }

            travelStayRepository.save(travelStayEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

}
