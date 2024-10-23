package com.koreait.mzpick_backend.service.implement.food;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.common.object.food.TravelFood;
import com.koreait.mzpick_backend.common.object.food.TravelFoodDetail;
import com.koreait.mzpick_backend.dto.request.food.PatchTravelFoodRequestDto;
import com.koreait.mzpick_backend.dto.request.food.PostTravelFoodRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.food.GetTravelFoodDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.food.GetTravelFoodListResponseDto;
import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodHashtagEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodLikeEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodPhotoEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodSaveEntity;
import com.koreait.mzpick_backend.repository.food.TravelFoodCommentRepository;
import com.koreait.mzpick_backend.repository.food.TravelFoodHashtagRepository;
import com.koreait.mzpick_backend.repository.food.TravelFoodLikeRepository;
import com.koreait.mzpick_backend.repository.food.TravelFoodPhotoRepository;
import com.koreait.mzpick_backend.repository.food.TravelFoodRepository;
import com.koreait.mzpick_backend.repository.food.TravelFoodSaveRepository;
import com.koreait.mzpick_backend.service.food.TravelFoodService;

import lombok.RequiredArgsConstructor;

//service 여행지 관련 서비스 //
@Service
@RequiredArgsConstructor
public class TravelFoodServiceImplement implements TravelFoodService {

    private final TravelFoodRepository travelFoodRepository;
    private final TravelFoodHashtagRepository travelFoodHashtagRepository;
    private final TravelFoodPhotoRepository travelFoodPhotoRepository;
    private final TravelFoodCommentRepository travelFoodCommentRepository;
    private final TravelFoodLikeRepository travelFoodLikeRepository;
    private final TravelFoodSaveRepository travelFoodSaveRepository;
    

    //Get 여행지 게시글 리스트 불러오기 //
    @Override
    public ResponseEntity<? super GetTravelFoodListResponseDto> getTravelFoodList(Integer page) {
        List<TravelFood> travelFoods = new ArrayList<>();
        try {
            Integer paging = 5 * (page - 1);
            List<TravelFoodEntity> travelFoodEntities = travelFoodRepository.findByPaging(paging);
            for (TravelFoodEntity travelFoodEntity : travelFoodEntities) {
                Integer travelFoodNumber = travelFoodEntity.getTravelFoodNumber();
                List<TravelFoodHashtagEntity> travelFoodHashtagEntities = travelFoodHashtagRepository.findByTravelFoodNumber(travelFoodNumber);
                List<TravelFoodPhotoEntity> travelFoodPhotoEntities = travelFoodPhotoRepository.findByTravelFoodNumber(travelFoodNumber);
                TravelFood travelFood = new TravelFood(travelFoodEntity, travelFoodPhotoEntities, travelFoodHashtagEntities, new ArrayList<>());
                travelFoods.add(travelFood);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetTravelFoodListResponseDto.success(travelFoods);
    }

    //Get 해당 여행 게시글 상세보기 //
    @Override
    public ResponseEntity<? super GetTravelFoodDetailResponseDto> getTravelFood(Integer travelFoodNumber) {
        TravelFoodDetail travelFoodDetail =  null;
        try {
            TravelFoodEntity travelFoodEntity = travelFoodRepository.findByTravelFoodNumber(travelFoodNumber);
            if (travelFoodEntity == null) return ResponseDto.noExistBoard();

            List<TravelFoodHashtagEntity> travelFoodHashtagEntities = travelFoodHashtagRepository.findByTravelFoodNumber(travelFoodNumber);
            List<TravelFoodPhotoEntity> travelFoodPhotoEntities = travelFoodPhotoRepository.findByTravelFoodNumber(travelFoodNumber);
            List<TravelFoodLikeEntity> travelFoodLikeEntities = travelFoodLikeRepository.findByTravelFoodNumber(travelFoodNumber);
            List<TravelFoodSaveEntity> travelFoodSaveEntities = travelFoodSaveRepository.findByTravelFoodNumber(travelFoodNumber);
            travelFoodDetail =  new TravelFoodDetail(travelFoodEntity, travelFoodPhotoEntities, travelFoodHashtagEntities, travelFoodLikeEntities, travelFoodSaveEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetTravelFoodDetailResponseDto.success(travelFoodDetail);
    }

    //Post 여행지 게시글 작성하기 //
    @Override
    public ResponseEntity<ResponseDto> postTravelFood(PostTravelFoodRequestDto dto, String userId) {
        try {
            TravelFoodEntity travelFoodEntity = new TravelFoodEntity(dto, userId);
            travelFoodRepository.save(travelFoodEntity);

            Integer travelFoodNumber = travelFoodEntity.getTravelFoodNumber();

            List<String> travelFoodHashtagContentList = dto.getTravelFoodHashtagContentList();
            List<TravelFoodHashtagEntity> travelFoodHashtagEntities = new ArrayList<>();
            for (String travelFoodHashtagContent : travelFoodHashtagContentList) {
                TravelFoodHashtagEntity travelFoodHashtagEntity = new TravelFoodHashtagEntity(travelFoodNumber, travelFoodHashtagContent);
                travelFoodHashtagEntities.add(travelFoodHashtagEntity);
            }
            travelFoodHashtagRepository.saveAll(travelFoodHashtagEntities);

            List<String> travelFoodPhotoList = dto.getTravelFoodPhotoList();
            List<TravelFoodPhotoEntity> travelFoodPhotoEntities = new ArrayList<>();
            for (String travelFoodPhotoLink : travelFoodPhotoList) {
                TravelFoodPhotoEntity travelFoodPhotoEntity = new TravelFoodPhotoEntity(travelFoodNumber, travelFoodPhotoLink);
                travelFoodPhotoEntities.add(travelFoodPhotoEntity);
            }
            travelFoodPhotoRepository.saveAll(travelFoodPhotoEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return ResponseDto.success();
    }

    //Delete 해당 여행지 게시판 삭제하기 //
    @Override
    public ResponseEntity<ResponseDto> deleteTravelFood(Integer travelFoodNumber, String userId) {
        try {
            TravelFoodEntity travelFoodEntity = travelFoodRepository.findByTravelFoodNumber(travelFoodNumber);
            if (travelFoodEntity == null) return ResponseDto.noExistBoard();
            String user = travelFoodEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser) return ResponseDto.noPermission();

            // travelHashtagRepository.deleteByTravelNumber(travelNumber);
            // travelPhotoRepository.deleteByTravelNumber(travelNumber);
            // travelCommentRepository.deleteByTravelNumber(travelNumber);
            travelFoodRepository.delete(travelFoodEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    //patch 해당 여행지 게시글 수정하기 //
    @Override
    public ResponseEntity<ResponseDto> patchTravelFood(PatchTravelFoodRequestDto dto, Integer travelFoodNumber, String userId) {
        try {
            TravelFoodEntity travelFoodEntity = travelFoodRepository.findByTravelFoodNumber(travelFoodNumber);
            if (travelFoodEntity == null) return ResponseDto.noExistBoard();

            String user = travelFoodEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser) return ResponseDto.noPermission();

            travelFoodHashtagRepository.deleteByTravelFoodNumber(travelFoodNumber);
            travelFoodPhotoRepository.deleteByTravelFoodNumber(travelFoodNumber);

            travelFoodEntity.patch(dto, userId);

            List<String> travelFoodHashtagContentList = dto.getTravelFoodHashtagContentList();
            List<TravelFoodHashtagEntity> travelFoodHashtagEntities = new ArrayList<>();
            for (String travelFoodHashtagContent : travelFoodHashtagContentList) {
                TravelFoodHashtagEntity travelFoodHashtagEntity = new TravelFoodHashtagEntity(travelFoodNumber, travelFoodHashtagContent);
                travelFoodHashtagEntities.add(travelFoodHashtagEntity);
            }
            travelFoodHashtagRepository.saveAll(travelFoodHashtagEntities);

            List<String> travelFoodPhotoList = dto.getTravelFoodPhotoList();
            List<TravelFoodPhotoEntity> travelFoodPhotoEntities = new ArrayList<>();
            for (String travelFoodPhotoLink : travelFoodPhotoList) {
                TravelFoodPhotoEntity travelFoodPhotoEntity = new TravelFoodPhotoEntity(travelFoodNumber, travelFoodPhotoLink);
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

    //put 해당 여행지 게시글 조회수 업 시키기 //
    @Override
    public ResponseEntity<ResponseDto> upTravelFoodViewCount(Integer travelFoodNumber) {
        try {
            TravelFoodEntity travelFoodEntity = travelFoodRepository.findByTravelFoodNumber(travelFoodNumber);
            if(travelFoodEntity == null) return ResponseDto.noExistBoard();

            travelFoodEntity.upViewCount();
            travelFoodRepository.save(travelFoodEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }


}
