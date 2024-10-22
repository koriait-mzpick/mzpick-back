package com.koreait.mzpick_backend.service.implement.travel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.common.object.Travel;
import com.koreait.mzpick_backend.common.object.TravelDetail;
import com.koreait.mzpick_backend.dto.request.travel.PatchTravelRequestDto;
import com.koreait.mzpick_backend.dto.request.travel.PostTravelRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelListResponseDto;
import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.entity.travel.TravelHashtagEntity;
import com.koreait.mzpick_backend.entity.travel.TravelLikeEntity;
import com.koreait.mzpick_backend.entity.travel.TravelPhotoEntity;
import com.koreait.mzpick_backend.entity.travel.TravelSaveEntity;
import com.koreait.mzpick_backend.repository.travel.TravelCommentRepository;
import com.koreait.mzpick_backend.repository.travel.TravelHashtagRepository;
import com.koreait.mzpick_backend.repository.travel.TravelLikeRepository;
import com.koreait.mzpick_backend.repository.travel.TravelPhotoRepository;
import com.koreait.mzpick_backend.repository.travel.TravelRepository;
import com.koreait.mzpick_backend.repository.travel.TravelSaveRepository;
import com.koreait.mzpick_backend.service.travel.TravelService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelServiceImplement implements TravelService {

    private final TravelRepository travelRepository;
    private final TravelHashtagRepository travelHashtagRepository;
    private final TravelPhotoRepository travelPhotoRepository;
    private final TravelCommentRepository travelCommentRepository;
    private final TravelLikeRepository travelLikeRepository;
    private final TravelSaveRepository travelSaveRepository;
    @Override
    public ResponseEntity<ResponseDto> postTravel(PostTravelRequestDto dto, String userId) {
        try {
            TravelEntity travelEntity = new TravelEntity(dto, userId);
            travelRepository.save(travelEntity);

            Integer travelNumber = travelEntity.getTravelNumber();

            List<String> travelHashtagContentList = dto.getTravelHashtagContentList();
            List<TravelHashtagEntity> travelHashtagEntities = new ArrayList<>();
            for (String travelHashtagContent : travelHashtagContentList) {
                TravelHashtagEntity travelHashtagEntity = new TravelHashtagEntity(travelNumber, travelHashtagContent);
                travelHashtagEntities.add(travelHashtagEntity);
            }
            travelHashtagRepository.saveAll(travelHashtagEntities);

            List<String> travelPhotoList = dto.getTravelPhotoList();
            List<TravelPhotoEntity> travelPhotoEntities = new ArrayList<>();
            for (String travelPhotoLink : travelPhotoList) {
                TravelPhotoEntity travelPhotoEntity = new TravelPhotoEntity(travelNumber, travelPhotoLink);
                travelPhotoEntities.add(travelPhotoEntity);
            }
            travelPhotoRepository.saveAll(travelPhotoEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteTravel(Integer travelNumber, String userId) {
        try {
            TravelEntity travelEntity = travelRepository.findByTravelNumber(travelNumber);
            if (travelEntity == null) return ResponseDto.noExistBoard();
            String user = travelEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser) return ResponseDto.noPermission();

            // travelHashtagRepository.deleteByTravelNumber(travelNumber);
            // travelPhotoRepository.deleteByTravelNumber(travelNumber);
            // travelCommentRepository.deleteByTravelNumber(travelNumber);
            travelRepository.delete(travelEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> patchTravel(
            PatchTravelRequestDto dto,
            Integer travelNumber,
            String userId) {
        try {
            TravelEntity travelEntity = travelRepository.findByTravelNumber(travelNumber);
            if (travelEntity == null) return ResponseDto.noExistBoard();

            String user = travelEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser) return ResponseDto.noPermission();

            travelHashtagRepository.deleteByTravelNumber(travelNumber);
            travelPhotoRepository.deleteByTravelNumber(travelNumber);

            travelEntity.patch(dto, userId);

            List<String> travelHashtagContentList = dto.getTravelHashtagContentList();
            List<TravelHashtagEntity> travelHashtagEntities = new ArrayList<>();
            for (String travelHashtagContent : travelHashtagContentList) {
                TravelHashtagEntity travelHashtagEntity = new TravelHashtagEntity(travelNumber, travelHashtagContent);
                travelHashtagEntities.add(travelHashtagEntity);
            }
            travelHashtagRepository.saveAll(travelHashtagEntities);

            List<String> travelPhotoList = dto.getTravelPhotoList();
            List<TravelPhotoEntity> travelPhotoEntities = new ArrayList<>();
            for (String travelPhotoLink : travelPhotoList) {
                TravelPhotoEntity travelPhotoEntity = new TravelPhotoEntity(travelNumber, travelPhotoLink);
                travelPhotoEntities.add(travelPhotoEntity);
            }
            travelPhotoRepository.saveAll(travelPhotoEntities);

            travelRepository.save(travelEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetTravelListResponseDto> getTravelList(Integer page) {

        List<Travel> travels = new ArrayList<>();

        try {
            Integer paging = 5 * (page - 1);
            List<TravelEntity> travelEntities = travelRepository.findByPaging(paging);
            for (TravelEntity travelEntity : travelEntities) {
                Integer travelNumber = travelEntity.getTravelNumber();
                List<TravelHashtagEntity> travelHashtagEntities = travelHashtagRepository.findByTravelNumber(travelNumber);
                List<TravelPhotoEntity> travelPhotoEntities = travelPhotoRepository.findByTravelNumber(travelNumber);
                Travel travel = new Travel(travelEntity, travelPhotoEntities, travelHashtagEntities, new ArrayList<>());
                travels.add(travel);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetTravelListResponseDto.success(travels);
    }

    @Override
    public ResponseEntity<? super GetTravelDetailResponseDto> getTravel(Integer travelNumber) {
        TravelDetail travelDetail =  null;
        try {
            TravelEntity travelEntity = travelRepository.findByTravelNumber(travelNumber);
            if (travelEntity == null) return ResponseDto.noExistBoard();

            List<TravelHashtagEntity> travelHashtagEntities = travelHashtagRepository.findByTravelNumber(travelNumber);
            List<TravelPhotoEntity> travelPhotoEntities = travelPhotoRepository.findByTravelNumber(travelNumber);
            List<TravelLikeEntity> travelLikeEntities = travelLikeRepository.findByTravelNumber(travelNumber);
            List<TravelSaveEntity> travelSaveEntities = travelSaveRepository.findByTravelNumber(travelNumber);
            travelDetail =  new TravelDetail(travelEntity, travelPhotoEntities, travelHashtagEntities, travelLikeEntities, travelSaveEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetTravelDetailResponseDto.success(travelDetail);
    }

    @Override
    public ResponseEntity<ResponseDto> upTravelViewCount(Integer travelNumber) {
        try {
            TravelEntity travelEntity = travelRepository.findByTravelNumber(travelNumber);
            if(travelEntity == null) return ResponseDto.noExistBoard();

            travelEntity.upViewCount();
            travelRepository.save(travelEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }
}
