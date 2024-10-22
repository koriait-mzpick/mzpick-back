package com.koreait.mzpick_backend.service.implement.cafe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.request.cafe.PatchTravelCafeRequestDto;
import com.koreait.mzpick_backend.dto.request.cafe.PostTravelCafeRequestDto;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeCategoryEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeHashtagEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafePhotoEntity;
import com.koreait.mzpick_backend.repository.cafe.TravelCafeCategoryRepository;
import com.koreait.mzpick_backend.repository.cafe.TravelCafeHashtagRepository;
import com.koreait.mzpick_backend.repository.cafe.TravelCafePhotoRepository;
import com.koreait.mzpick_backend.repository.cafe.TravelCafeRepository;

import com.koreait.mzpick_backend.service.cafe.TravelCafeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelCafeServiceImplement implements TravelCafeService {
    private final TravelCafeRepository travelCafeRepository;
    private final TravelCafeCategoryRepository travelCafeCategoryRepository;
    private final TravelCafePhotoRepository travelCafePhotoRepository;
    private final TravelCafeHashtagRepository travelCafeHashtagRepository;

    @Override
    public ResponseEntity<ResponseDto> postTravelCafe(PostTravelCafeRequestDto dto, String userId) {
        try {
            TravelCafeEntity TravelCafeEntity = new TravelCafeEntity(dto, userId);
            travelCafeRepository.save(TravelCafeEntity);

            Integer travelCafeNumber = TravelCafeEntity.getTravelCafeNumber();

            List<String> travelCafeHashtagContentList = dto.getTravelCafeHashtagContentList();
            List<TravelCafeHashtagEntity> travelCafeHashtagEntities = new ArrayList<>();
            for (String travelCafeHashtagContent : travelCafeHashtagContentList) {
                TravelCafeHashtagEntity travelCafeHashtagEntity = new TravelCafeHashtagEntity(travelCafeNumber,
                        travelCafeHashtagContent);
                travelCafeHashtagEntities.add(travelCafeHashtagEntity);
            }
            travelCafeHashtagRepository.saveAll(travelCafeHashtagEntities);

            List<String> travelCafePhotoList = dto.getTravelCafePhotoList();
            List<TravelCafePhotoEntity> travelCafePhotoEntities = new ArrayList<>();
            for (String travelCafePhotoLink : travelCafePhotoList) {
                TravelCafePhotoEntity travelCafePhotoEntity = new TravelCafePhotoEntity(travelCafeNumber,
                        travelCafePhotoLink);
                travelCafePhotoEntities.add(travelCafePhotoEntity);
            }
            travelCafePhotoRepository.saveAll(travelCafePhotoEntities);

            List<String> travelCafeCategoryList = dto.getTravelCafeCategoryList();
            List<TravelCafeCategoryEntity> travelCafeCategoryEntities = new ArrayList<>();
            for (String travelCafeCategory : travelCafeCategoryList) {
                TravelCafeCategoryEntity travelCafeCategoryEntity = new TravelCafeCategoryEntity(travelCafeNumber,
                        travelCafeCategory);
                travelCafeCategoryEntities.add(travelCafeCategoryEntity);
            }
            travelCafeCategoryRepository.saveAll(travelCafeCategoryEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> patchTravelCafe(PatchTravelCafeRequestDto dto, Integer travelCafeNumber, String userId) {
        try {
            TravelCafeEntity travelCafeEntity = travelCafeRepository.findByTravelCafeNumber(travelCafeNumber);
            if (travelCafeEntity == null)
                return ResponseDto.noExistBoard();

            String user = travelCafeEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser)
                return ResponseDto.noPermission();

            travelCafePhotoRepository.deleteByTravelCafeNumber(travelCafeNumber);
            travelCafePhotoRepository.deleteByTravelCafeNumber(travelCafeNumber);
            travelCafeCategoryRepository.deleteByTravelCafeNumber(travelCafeNumber);

            travelCafeEntity.patch(dto, userId);

            List<String> travelCafeHashtagContentList = dto.getTravelCafeHashtagContentList();
            List<TravelCafeHashtagEntity> travelCafeHashtagEntities = new ArrayList<>();
            for (String travelCafeHashtagContent : travelCafeHashtagContentList) {
                TravelCafeHashtagEntity travelCafeHashtagEntity = new TravelCafeHashtagEntity(travelCafeNumber,
                        travelCafeHashtagContent);
                travelCafeHashtagEntities.add(travelCafeHashtagEntity);
            }
            travelCafeHashtagRepository.saveAll(travelCafeHashtagEntities);

            List<String> travelCafePhotoList = dto.getTravelCafePhotoList();
            List<TravelCafePhotoEntity> travelCafePhotoEntities = new ArrayList<>();
            for (String travelCafePhotoLink : travelCafePhotoList) {
                TravelCafePhotoEntity travelCafePhotoEntity = new TravelCafePhotoEntity(travelCafeNumber,
                        travelCafePhotoLink);
                travelCafePhotoEntities.add(travelCafePhotoEntity);
            }
            travelCafePhotoRepository.saveAll(travelCafePhotoEntities);

            List<String> travelCafeCategoryList = dto.getTravelCafeCategoryList();
            List<TravelCafeCategoryEntity> travelCafeCategoryEntities = new ArrayList<>();
            for (String travelCafeCategory : travelCafeCategoryList) {
                TravelCafeCategoryEntity travelCafeCategoryEntity = new TravelCafeCategoryEntity(travelCafeNumber,
                        travelCafeCategory);
                travelCafeCategoryEntities.add(travelCafeCategoryEntity);
            }
            travelCafeCategoryRepository.saveAll(travelCafeCategoryEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteTravelCafe(Integer travelCafeNumber, String userId){ 
        try {
            TravelCafeEntity travelCafeEntity = travelCafeRepository.findByTravelCafeNumber(travelCafeNumber);
            if (travelCafeEntity == null)
                return ResponseDto.noExistBoard();

            String user = travelCafeEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser)
                return ResponseDto.noPermission();

            travelCafePhotoRepository.deleteByTravelCafeNumber(travelCafeNumber);
            travelCafePhotoRepository.deleteByTravelCafeNumber(travelCafeNumber);
            travelCafeCategoryRepository.deleteByTravelCafeNumber(travelCafeNumber);
            travelCafeRepository.delete(travelCafeEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> getTravelCafe() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTravelCafe'");
    }

    @Override
    public ResponseEntity<ResponseDto> getTravelCafeNum(Integer travelCafeNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTravelCafeNum'");
    }
}
