package com.koreait.mzpick_backend.service.implement.fashion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.common.object.fashion.Fashion;
import com.koreait.mzpick_backend.common.object.fashion.FashionDetail;
import com.koreait.mzpick_backend.dto.request.fashion.PatchFashionRequestDto;
import com.koreait.mzpick_backend.dto.request.fashion.PostFashionRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionListResponseDto;
import com.koreait.mzpick_backend.entity.fashion.FashionEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionHashtagEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionLikeEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionPhotoEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionSaveEntity;
import com.koreait.mzpick_backend.repository.fashion.FashionHashtagRepository;
import com.koreait.mzpick_backend.repository.fashion.FashionLikeRepository;
import com.koreait.mzpick_backend.repository.fashion.FashionPhotoRepository;
import com.koreait.mzpick_backend.repository.fashion.FashionRepository;
import com.koreait.mzpick_backend.repository.fashion.FashionSaveRepository;
import com.koreait.mzpick_backend.service.fashion.FashionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FashionServiceImplement implements FashionService {

    private final FashionRepository fashionRepository;
    private final FashionHashtagRepository fashionHashtagRepository;
    private final FashionPhotoRepository fashionPhotoRepository;
    private final FashionLikeRepository fashionLikeRepository;
    private final FashionSaveRepository fashionSaveRepository;

    @Override
    public ResponseEntity<? super GetFashionListResponseDto> getFashionList(Integer page) {
        List<Fashion> Fashions = new ArrayList<>();

        try {
            Integer paging = 5 * (page - 1);
            List<FashionEntity> fashionEntities = fashionRepository.findByPaging(paging);
            for (FashionEntity fashionEntity : fashionEntities) {
                Integer fashionNumber = fashionEntity.getFashionNumber();
                List<FashionHashtagEntity> fashionHashtagEntities = fashionHashtagRepository.findByFashionNumber(fashionNumber);
                List<FashionPhotoEntity> fashionPhotoEntities = fashionPhotoRepository.findByFashionNumber(fashionNumber);
                List<FashionLikeEntity> fashionLikeEntities = fashionLikeRepository.findByFashionNumber(fashionNumber);
                List<FashionSaveEntity> fashionSaveEntities = fashionSaveRepository.findByFashionNumber(fashionNumber);
                Fashion fashion = new Fashion(fashionEntity, fashionPhotoEntities, fashionHashtagEntities, fashionLikeEntities, fashionSaveEntities);
                Fashions.add(fashion);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetFashionListResponseDto.success(Fashions);
    }

    @Override
    public ResponseEntity<? super GetFashionDetailResponseDto> getFashion(Integer fashionNumber) {
        FashionDetail fashionDetail =  null;
        try {
            FashionEntity fashionEntity = fashionRepository.findByFashionNumber(fashionNumber);
            if (fashionEntity == null) return ResponseDto.noExistBoard();

            List<FashionHashtagEntity> fashionHashtagEntities = fashionHashtagRepository.findByFashionNumber(fashionNumber);
            List<FashionPhotoEntity> fashionPhotoEntities = fashionPhotoRepository.findByFashionNumber(fashionNumber);
            List<FashionLikeEntity> fashionLikeEntities = fashionLikeRepository.findByFashionNumber(fashionNumber);
            List<FashionSaveEntity> fashionSaveEntities = fashionSaveRepository.findByFashionNumber(fashionNumber);
            fashionDetail =  new FashionDetail(fashionEntity, fashionPhotoEntities, fashionHashtagEntities, fashionLikeEntities, fashionSaveEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetFashionDetailResponseDto.success(fashionDetail);
    }

    @Override
    public ResponseEntity<ResponseDto> postFashion(PostFashionRequestDto dto, String userId) {
        try {
            FashionEntity fashionEntity = new FashionEntity(dto, userId);
            fashionRepository.save(fashionEntity);

            Integer fashionNumber = fashionEntity.getFashionNumber();

            List<String> fashionHashtagContentList = dto.getFashionHashtagContent();
            List<FashionHashtagEntity> fashionHashtagEntities = new ArrayList<>();
            for (String fashionHashtagContent : fashionHashtagContentList) {
                FashionHashtagEntity fashionHashtagEntity = new FashionHashtagEntity(fashionNumber, fashionHashtagContent);
                fashionHashtagEntities.add(fashionHashtagEntity);
            }
            fashionHashtagRepository.saveAll(fashionHashtagEntities);

            List<String> fashionPhotoList = dto.getFashionPhoto();
            List<FashionPhotoEntity> fashionPhotoEntities = new ArrayList<>();
            for (String fashionPhotoLink : fashionPhotoList) {
                FashionPhotoEntity fashionPhotoEntity = new FashionPhotoEntity(fashionNumber, fashionPhotoLink);
                fashionPhotoEntities.add(fashionPhotoEntity);
            }
            fashionPhotoRepository.saveAll(fashionPhotoEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteFashion(Integer FashionNumber, String userId) {
            try {
            FashionEntity fashionEntity = fashionRepository.findByFashionNumber(FashionNumber);
            if (fashionEntity == null) return ResponseDto.noExistBoard();
            String user = fashionEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser) return ResponseDto.noPermission();

            // travelHashtagRepository.deleteByTravelNumber(travelNumber);
            // travelPhotoRepository.deleteByTravelNumber(travelNumber);
            // travelCommentRepository.deleteByTravelNumber(travelNumber);
            fashionRepository.delete(fashionEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> patchFashion(PatchFashionRequestDto dto, Integer fashionNumber, String userId) {
        try{
            FashionEntity fashionEntity = fashionRepository.findByFashionNumber(fashionNumber);
            if(fashionEntity == null) return ResponseDto.noExistBoard();
            String user = fashionEntity.getUserId();
            boolean isUser = user.equals(userId);
            if(!isUser) return ResponseDto.noPermission();
            
            fashionHashtagRepository.deleteByFashionNumber(fashionNumber);
            fashionPhotoRepository.deleteByFashionNumber(fashionNumber);

            fashionEntity.patch(dto, userId);

            List<String> fashionHashtagContentList = dto.getFashionHashtagContent();
            List<FashionHashtagEntity> fashionHashtagEntities = new ArrayList<>();
            for (String fashionHashtagContent : fashionHashtagContentList) {
                FashionHashtagEntity fashionHashtagEntity = new FashionHashtagEntity(fashionNumber, fashionHashtagContent);
                fashionHashtagEntities.add(fashionHashtagEntity);
            }
            fashionHashtagRepository.saveAll(fashionHashtagEntities);

            List<String> fashionPhotoList = dto.getFashionPhoto();
            List<FashionPhotoEntity> fashionPhotoEntities = new ArrayList<>();
            for (String fashionPhotoLink : fashionPhotoList) {
                FashionPhotoEntity fashionPhotoEntity = new FashionPhotoEntity(fashionNumber, fashionPhotoLink);
                fashionPhotoEntities.add(fashionPhotoEntity);
        }
        fashionPhotoRepository.saveAll(fashionPhotoEntities);

        fashionRepository.save(fashionEntity);

    } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
    }
    return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> upFashionViewCount(Integer FashionNumber) {
        try {
            FashionEntity fashionEntity = fashionRepository.findByFashionNumber(FashionNumber);
            if(fashionEntity == null ) return ResponseDto.noExistBoard();
            fashionEntity.upViewCount();
            fashionRepository.save(fashionEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

}
