package com.koreait.mzpick_backend.service.implement.food;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.request.food.PatchTravelFoodRequestDto;
import com.koreait.mzpick_backend.dto.request.food.PostTravelFoodRequestDto;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodHashtagEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodPhotoEntity;
import com.koreait.mzpick_backend.repository.food.TravelFoodHashtagRepository;
import com.koreait.mzpick_backend.repository.food.TravelFoodPhotoRepository;
import com.koreait.mzpick_backend.repository.food.TravelFoodRepository;

import com.koreait.mzpick_backend.service.food.TravelFoodService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelFoodServiceImplement implements TravelFoodService {

    private final TravelFoodRepository travelFoodRepository;
    private final TravelFoodHashtagRepository travelFoodHashtagRepository;
    private final TravelFoodPhotoRepository travelFoodPhotoRepository;

    @Override
    public ResponseEntity<ResponseDto> postTravelFood(PostTravelFoodRequestDto dto, String userId) {
        try {
            TravelFoodEntity travelFoodEntity = new TravelFoodEntity(dto, userId);
            travelFoodRepository.save(travelFoodEntity);

            Integer travelFoodNumber = travelFoodEntity.getTravelFoodNumber();

            List<String> travelFoodHashtagContentList = dto.getTravelFoodHashtagContentList();
            List<TravelFoodHashtagEntity> travelFoodHashtagEntities = new ArrayList<>();
            for (String travelFoodHashtagContent : travelFoodHashtagContentList) {
                TravelFoodHashtagEntity travelFoodHashtagEntity = new TravelFoodHashtagEntity(travelFoodNumber,
                        travelFoodHashtagContent);
                travelFoodHashtagEntities.add(travelFoodHashtagEntity);
            }
            travelFoodHashtagRepository.saveAll(travelFoodHashtagEntities);

            List<String> travelFoodPhotoList = dto.getTravelFoodPhotoList();
            List<TravelFoodPhotoEntity> travelFoodPhotoEntities = new ArrayList<>();
            for (String travelFoodPhotoLink : travelFoodPhotoList) {
                TravelFoodPhotoEntity travelFoodPhotoEntity = new TravelFoodPhotoEntity(travelFoodNumber,
                        travelFoodPhotoLink);
                travelFoodPhotoEntities.add(travelFoodPhotoEntity);
            }
            travelFoodPhotoRepository.saveAll(travelFoodPhotoEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> patchTravelFood(PatchTravelFoodRequestDto dto, Integer travelFoodNumber,
            String userId) {

        try {
            TravelFoodEntity travelFoodEntity = travelFoodRepository.findByTravelFoodNumber(travelFoodNumber);
            if (travelFoodEntity == null)
                return ResponseDto.noExistBoard();

            String user = travelFoodEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser)
                return ResponseDto.noPermission();

            travelFoodHashtagRepository.deleteByTravelFoodNumber(travelFoodNumber);
            travelFoodPhotoRepository.deleteByTravelFoodNumber(travelFoodNumber);

            travelFoodEntity.patch(dto, userId);

            List<String> travelFoodHashtagContentList = dto.getTravelFoodHashtagContentList();
            List<TravelFoodHashtagEntity> travelFoodHashtagEntities = new ArrayList<>();
            for (String travelFoodHashtagContent : travelFoodHashtagContentList) {
                TravelFoodHashtagEntity travelFoodHashtagEntity = new TravelFoodHashtagEntity(travelFoodNumber,
                        travelFoodHashtagContent);
                travelFoodHashtagEntities.add(travelFoodHashtagEntity);
            }

            List<String> travelFoodPhotoList = dto.getTravelFoodPhotoList();
            List<TravelFoodPhotoEntity> travelFoodPhotoEntities = new ArrayList<>();
            for (String travelFoodPhotoLink : travelFoodPhotoList) {
                TravelFoodPhotoEntity travelFoodPhotoEntity = new TravelFoodPhotoEntity(travelFoodNumber,
                        travelFoodPhotoLink);
                travelFoodPhotoEntities.add(travelFoodPhotoEntity);
            }
            travelFoodPhotoRepository.saveAll(travelFoodPhotoEntities);

            travelFoodRepository.save(travelFoodEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteTravelFood(Integer travelFoodNumber, String userId) {

        try {
            TravelFoodEntity travelFoodEntity = travelFoodRepository.findByTravelFoodNumber(travelFoodNumber);
            if(travelFoodEntity == null) return ResponseDto.noExistBoard();
            String user = travelFoodEntity.getUserId();
            boolean isUser = user.equals(userId);
            if(!isUser) return ResponseDto.noPermission();

            travelFoodHashtagRepository.deleteByTravelFoodNumber(travelFoodNumber);
            travelFoodPhotoRepository.deleteByTravelFoodNumber(travelFoodNumber);
            travelFoodRepository.delete(travelFoodEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();

    }

    @Override
    public ResponseEntity<ResponseDto> getTravelFood() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTravelFood'");
    }

    @Override
    public ResponseEntity<ResponseDto> getTravelFoodNum(Integer travelFoodNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTravelFoodNum'");
    }

}
