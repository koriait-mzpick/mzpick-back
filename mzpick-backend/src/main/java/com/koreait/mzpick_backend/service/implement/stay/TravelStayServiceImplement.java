package com.koreait.mzpick_backend.service.implement.stay;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.request.stay.PatchTravelStayRequestDto;
import com.koreait.mzpick_backend.dto.request.stay.PostTravelStayRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.stay.TravelStayCategoryEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayHashtagEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayPhotoEntity;
import com.koreait.mzpick_backend.repository.stay.TravelStayCategoryRepository;
import com.koreait.mzpick_backend.repository.stay.TravelStayHashtagRepository;
import com.koreait.mzpick_backend.repository.stay.TravelStayPhotoRepository;
import com.koreait.mzpick_backend.repository.stay.TravelStayRepository;
import com.koreait.mzpick_backend.service.stay.TravelStayService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelStayServiceImplement implements TravelStayService {

    private final TravelStayRepository travelStayRepository;
    private final TravelStayCategoryRepository travelStayCategoryRepository;
    private final TravelStayPhotoRepository travelStayPhotoRepository;
    private final TravelStayHashtagRepository travelStayHashtagRepository;

    @Override
    public ResponseEntity<ResponseDto> postTravelStay(PostTravelStayRequestDto dto, String userId) {
        try {
            TravelStayEntity TravelStayEntity = new TravelStayEntity(dto, userId);
            travelStayRepository.save(TravelStayEntity);

            Integer travelStayNumber = TravelStayEntity.getTravelStayNumber();

            List<String> travelStayHashtagContentList = dto.getTravelStayHashtagContentList();
            List<TravelStayHashtagEntity> travelStayHashtagEntities = new ArrayList<>();
            for (String travelStayHashtagContent : travelStayHashtagContentList) {
                TravelStayHashtagEntity travelStayHashtagEntity = new TravelStayHashtagEntity(travelStayNumber,
                        travelStayHashtagContent);
                travelStayHashtagEntities.add(travelStayHashtagEntity);
            }
            travelStayHashtagRepository.saveAll(travelStayHashtagEntities);

            List<String> travelStayPhotoList = dto.getTravelStayPhotoList();
            List<TravelStayPhotoEntity> travelStayPhotoEntities = new ArrayList<>();
            for (String travelStayPhotoLink : travelStayPhotoList) {
                TravelStayPhotoEntity travelStayPhotoEntity = new TravelStayPhotoEntity(travelStayNumber,
                        travelStayPhotoLink);
                travelStayPhotoEntities.add(travelStayPhotoEntity);
            }
            travelStayPhotoRepository.saveAll(travelStayPhotoEntities);

            List<String> travelStayCategoryList = dto.getTravelStayCategoryList();
            List<TravelStayCategoryEntity> travelStayCategoryEntities = new ArrayList<>();
            for (String travelStayCategory : travelStayCategoryList) {
                TravelStayCategoryEntity travelStayCategoryEntity = new TravelStayCategoryEntity(travelStayNumber,
                        travelStayCategory);
                travelStayCategoryEntities.add(travelStayCategoryEntity);
            }
            travelStayCategoryRepository.saveAll(travelStayCategoryEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> patchTravelStay(PatchTravelStayRequestDto dto, Integer travelStayNumber,
            String userId) {
        try {
            TravelStayEntity travelStayEntity = travelStayRepository.findByTravelStayNumber(travelStayNumber);
            if (travelStayEntity == null)
                return ResponseDto.noExistBoard();

            String user = travelStayEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser)
                return ResponseDto.noPermission();

            travelStayPhotoRepository.deleteByTravelStayNumber(travelStayNumber);
            travelStayPhotoRepository.deleteByTravelStayNumber(travelStayNumber);
            travelStayCategoryRepository.deleteByTravelStayNumber(travelStayNumber);

            travelStayEntity.patch(dto, userId);

            List<String> travelStayHashtagContentList = dto.getTravelStayHashtagContentList();
            List<TravelStayHashtagEntity> travelStayHashtagEntities = new ArrayList<>();
            for (String travelStayHashtagContent : travelStayHashtagContentList) {
                TravelStayHashtagEntity travelStayHashtagEntity = new TravelStayHashtagEntity(travelStayNumber,
                        travelStayHashtagContent);
                travelStayHashtagEntities.add(travelStayHashtagEntity);
            }
            travelStayHashtagRepository.saveAll(travelStayHashtagEntities);

            List<String> travelStayPhotoList = dto.getTravelStayPhotoList();
            List<TravelStayPhotoEntity> travelStayPhotoEntities = new ArrayList<>();
            for (String travelStayPhotoLink : travelStayPhotoList) {
                TravelStayPhotoEntity travelStayPhotoEntity = new TravelStayPhotoEntity(travelStayNumber,
                        travelStayPhotoLink);
                travelStayPhotoEntities.add(travelStayPhotoEntity);
            }
            travelStayPhotoRepository.saveAll(travelStayPhotoEntities);

            List<String> travelStayCategoryList = dto.getTravelStayCategoryList();
            List<TravelStayCategoryEntity> travelStayCategoryEntities = new ArrayList<>();
            for (String travelStayCategory : travelStayCategoryList) {
                TravelStayCategoryEntity travelStayCategoryEntity = new TravelStayCategoryEntity(travelStayNumber,
                        travelStayCategory);
                travelStayCategoryEntities.add(travelStayCategoryEntity);
            }
            travelStayCategoryRepository.saveAll(travelStayCategoryEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteTravelStay(Integer travelStayNumber, String userId) {

        try {
            TravelStayEntity travelStayEntity = travelStayRepository.findByTravelStayNumber(travelStayNumber);
            if (travelStayEntity == null)
                return ResponseDto.noExistBoard();

            String user = travelStayEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser)
                return ResponseDto.noPermission();

            travelStayPhotoRepository.deleteByTravelStayNumber(travelStayNumber);
            travelStayPhotoRepository.deleteByTravelStayNumber(travelStayNumber);
            travelStayCategoryRepository.deleteByTravelStayNumber(travelStayNumber);
            travelStayRepository.delete(travelStayEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> getTravelStay() {
        throw new UnsupportedOperationException("Unimplemented method 'getTravelStay'");
    }

    @Override
    public ResponseEntity<ResponseDto> getTravelStayNum(Integer travelStayNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTravelStayNum'");
    }

}
