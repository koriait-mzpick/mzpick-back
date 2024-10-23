package com.koreait.mzpick_backend.service.implement.stay;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.common.object.stay.TravelStay;
import com.koreait.mzpick_backend.common.object.stay.TravelStayDetail;
import com.koreait.mzpick_backend.dto.request.stay.PatchTravelStayRequestDto;
import com.koreait.mzpick_backend.dto.request.stay.PostTravelStayRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.stay.GetTravelStayDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.stay.GetTravelStayListResponseDto;
import com.koreait.mzpick_backend.entity.stay.TravelStayCategoryEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayHashtagEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayLikeEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayPhotoEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStaySaveEntity;
import com.koreait.mzpick_backend.repository.stay.TravelStayCategoryRepository;
import com.koreait.mzpick_backend.repository.stay.TravelStayCommentRepository;
import com.koreait.mzpick_backend.repository.stay.TravelStayHashtagRepository;
import com.koreait.mzpick_backend.repository.stay.TravelStayLikeRepository;
import com.koreait.mzpick_backend.repository.stay.TravelStayPhotoRepository;
import com.koreait.mzpick_backend.repository.stay.TravelStayRepository;
import com.koreait.mzpick_backend.repository.stay.TravelStaySaveRepository;
import com.koreait.mzpick_backend.service.stay.TravelStayService;

import lombok.RequiredArgsConstructor;

//service 여행지 관련 서비스 //
@Service
@RequiredArgsConstructor
public class TravelStayServiceImplement implements TravelStayService {

    private final TravelStayRepository travelStayRepository;
    private final TravelStayHashtagRepository travelStayHashtagRepository;
    private final TravelStayPhotoRepository travelStayPhotoRepository;
    private final TravelStayCommentRepository travelStayCommentRepository;
    private final TravelStayLikeRepository travelStayLikeRepository;
    private final TravelStaySaveRepository travelStaySaveRepository;
    private final TravelStayCategoryRepository travelStayCategoryRepository;
    

    //Get 여행지 게시글 리스트 불러오기 //
    @Override
    public ResponseEntity<? super GetTravelStayListResponseDto> getTravelStayList(Integer page) {
        List<TravelStay> travelStays = new ArrayList<>();
        try {
            Integer paging = 5 * (page - 1);
            List<TravelStayEntity> travelStayEntities = travelStayRepository.findByPaging(paging);
            for (TravelStayEntity travelStayEntity : travelStayEntities) {
                Integer travelStayNumber = travelStayEntity.getTravelStayNumber();
                List<TravelStayHashtagEntity> travelStayHashtagEntities = travelStayHashtagRepository.findByTravelStayNumber(travelStayNumber);
                List<TravelStayPhotoEntity> travelStayPhotoEntities = travelStayPhotoRepository.findByTravelStayNumber(travelStayNumber);
                List<TravelStayCategoryEntity> travelStayCategoryEntities = travelStayCategoryRepository.findByTravelStayNumber(travelStayNumber);
                TravelStay travelStay = new TravelStay(travelStayEntity, travelStayPhotoEntities, travelStayHashtagEntities, travelStayCategoryEntities);
                travelStays.add(travelStay);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetTravelStayListResponseDto.success(travelStays);
    }

    //Get 해당 여행 게시글 상세보기 //
    @Override
    public ResponseEntity<? super GetTravelStayDetailResponseDto> getTravelStay(Integer travelStayNumber) {
        TravelStayDetail travelStayDetail =  null;
        try {
            TravelStayEntity travelStayEntity = travelStayRepository.findByTravelStayNumber(travelStayNumber);
            if (travelStayEntity == null) return ResponseDto.noExistBoard();

            List<TravelStayHashtagEntity> travelStayHashtagEntities = travelStayHashtagRepository.findByTravelStayNumber(travelStayNumber);
            List<TravelStayPhotoEntity> travelStayPhotoEntities = travelStayPhotoRepository.findByTravelStayNumber(travelStayNumber);
            List<TravelStayLikeEntity> travelStayLikeEntities = travelStayLikeRepository.findByTravelStayNumber(travelStayNumber);
            List<TravelStaySaveEntity> travelStaySaveEntities = travelStaySaveRepository.findByTravelStayNumber(travelStayNumber);
            List<TravelStayCategoryEntity> travelStayCategoryEntities = travelStayCategoryRepository.findByTravelStayNumber(travelStayNumber);
            travelStayDetail =  new TravelStayDetail(travelStayEntity, travelStayPhotoEntities, travelStayHashtagEntities, travelStayLikeEntities, travelStaySaveEntities, travelStayCategoryEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetTravelStayDetailResponseDto.success(travelStayDetail);
    }

    //Post 여행지 게시글 작성하기 //
    @Override
    public ResponseEntity<ResponseDto> postTravelStay(PostTravelStayRequestDto dto, String userId) {
        try {
            TravelStayEntity travelStayEntity = new TravelStayEntity(dto, userId);
            travelStayRepository.save(travelStayEntity);

            Integer travelStayNumber = travelStayEntity.getTravelStayNumber();

            List<String> travelStayHashtagContentList = dto.getTravelStayHashtagContentList();
            List<TravelStayHashtagEntity> travelStayHashtagEntities = new ArrayList<>();
            for (String travelStayHashtagContent : travelStayHashtagContentList) {
                TravelStayHashtagEntity travelStayHashtagEntity = new TravelStayHashtagEntity(travelStayNumber, travelStayHashtagContent);
                travelStayHashtagEntities.add(travelStayHashtagEntity);
            }
            travelStayHashtagRepository.saveAll(travelStayHashtagEntities);

            List<String> travelStayPhotoList = dto.getTravelStayPhotoList();
            List<TravelStayPhotoEntity> travelStayPhotoEntities = new ArrayList<>();
            for (String travelStayPhotoLink : travelStayPhotoList) {
                TravelStayPhotoEntity travelStayPhotoEntity = new TravelStayPhotoEntity(travelStayNumber, travelStayPhotoLink);
                travelStayPhotoEntities.add(travelStayPhotoEntity);
            }
            travelStayPhotoRepository.saveAll(travelStayPhotoEntities);

            List<String> travelStayCategoryList = dto.getTravelStayCategoryList();
            List<TravelStayCategoryEntity> travelStayCategoryEntities = new ArrayList<>();
            for (String travelStayCategory : travelStayCategoryList) {
                TravelStayCategoryEntity travelStayCategoryEntity = new TravelStayCategoryEntity(travelStayNumber, travelStayCategory);
                travelStayCategoryEntities.add(travelStayCategoryEntity);
            }
            travelStayCategoryRepository.saveAll(travelStayCategoryEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return ResponseDto.success();
    }

    //Delete 해당 여행지 게시판 삭제하기 //
    @Override
    public ResponseEntity<ResponseDto> deleteTravelStay(Integer travelStayNumber, String userId) {
        try {
            TravelStayEntity travelStayEntity = travelStayRepository.findByTravelStayNumber(travelStayNumber);
            if (travelStayEntity == null) return ResponseDto.noExistBoard();
            String user = travelStayEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser) return ResponseDto.noPermission();

            // travelHashtagRepository.deleteByTravelNumber(travelNumber);
            // travelPhotoRepository.deleteByTravelNumber(travelNumber);
            // travelCommentRepository.deleteByTravelNumber(travelNumber);
            travelStayRepository.delete(travelStayEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    //patch 해당 여행지 게시글 수정하기 //
    @Override
    public ResponseEntity<ResponseDto> patchTravelStay(PatchTravelStayRequestDto dto, Integer travelStayNumber, String userId) {
        try {
            TravelStayEntity travelStayEntity = travelStayRepository.findByTravelStayNumber(travelStayNumber);
            if (travelStayEntity == null) return ResponseDto.noExistBoard();

            String user = travelStayEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser) return ResponseDto.noPermission();

            travelStayHashtagRepository.deleteByTravelStayNumber(travelStayNumber);
            travelStayPhotoRepository.deleteByTravelStayNumber(travelStayNumber);
            travelStayCategoryRepository.deleteByTravelStayNumber(travelStayNumber);
            travelStayEntity.patch(dto, userId);

            List<String> travelStayHashtagContentList = dto.getTravelStayHashtagContentList();
            List<TravelStayHashtagEntity> travelStayHashtagEntities = new ArrayList<>();
            for (String travelStayHashtagContent : travelStayHashtagContentList) {
                TravelStayHashtagEntity travelStayHashtagEntity = new TravelStayHashtagEntity(travelStayNumber, travelStayHashtagContent);
                travelStayHashtagEntities.add(travelStayHashtagEntity);
            }
            travelStayHashtagRepository.saveAll(travelStayHashtagEntities);

            List<String> travelStayPhotoList = dto.getTravelStayPhotoList();
            List<TravelStayPhotoEntity> travelStayPhotoEntities = new ArrayList<>();
            for (String travelStayPhotoLink : travelStayPhotoList) {
                TravelStayPhotoEntity travelStayPhotoEntity = new TravelStayPhotoEntity(travelStayNumber, travelStayPhotoLink);
                travelStayPhotoEntities.add(travelStayPhotoEntity);
            }
            travelStayPhotoRepository.saveAll(travelStayPhotoEntities);


            List<String> travelStayCategoryList = dto.getTravelStayCategoryList();
            List<TravelStayCategoryEntity> travelStayCategoryEntities = new ArrayList<>();
            for (String travelStayCategory : travelStayCategoryList) {
                TravelStayCategoryEntity travelStayCategoryEntity = new TravelStayCategoryEntity(travelStayNumber, travelStayCategory);
                travelStayCategoryEntities.add(travelStayCategoryEntity);
            }
            travelStayCategoryRepository.saveAll(travelStayCategoryEntities);

            travelStayRepository.save(travelStayEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    //put 해당 여행지 게시글 조회수 업 시키기 //
    @Override
    public ResponseEntity<ResponseDto> upTravelStayViewCount(Integer travelStayNumber) {
        try {
            TravelStayEntity travelStayEntity = travelStayRepository.findByTravelStayNumber(travelStayNumber);
            if(travelStayEntity == null) return ResponseDto.noExistBoard();

            travelStayEntity.upViewCount();
            travelStayRepository.save(travelStayEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }


}
