package com.koreait.mzpick_backend.service.implement.travel;

import org.springframework.http.ResponseEntity;
<<<<<<< HEAD

import com.koreait.mzpick_backend.dto.request.travel.PostTravelCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.travel.TravelCommentService;

public class TravelCommentServiceImplement implements TravelCommentService {

    @Override
    public ResponseEntity<ResponseDto> getComment(Integer travelNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getComment'");
    }

    @Override
    public ResponseEntity<ResponseDto> postComment(PostTravelCommentRequestDto dto, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postComment'");
    }

    @Override
    public ResponseEntity<ResponseDto> deletecomment(Integer travelCommentNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletecomment'");
    }
    
=======
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.travel.TravelCommentEntity;
import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.repository.travel.TravelCommentRepository;
import com.koreait.mzpick_backend.repository.travel.TravelRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.travel.TravelCommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelCommentServiceImplement implements TravelCommentService {
    private final TravelRepository travelRepository;
    private final TravelCommentRepository travelCommentRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseDto> postTravelComment(PostTravelCommentRequestDto dto, Integer travelNumber,
            String userId) {
        try {
            TravelEntity travelEntity = travelRepository.findByTravelNumber(travelNumber);
            if (travelEntity == null)
                return ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser)
                return ResponseDto.noExistUserId();

            TravelCommentEntity travelCommentEntity = new TravelCommentEntity(dto, travelNumber, userId);
            travelCommentRepository.save(travelCommentEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteTravelComment(Integer travelCommentNumber, String userId) {
        try {
            TravelCommentEntity travelCommentEntity = travelCommentRepository.findByTravelCommentNumber(travelCommentNumber);
            if(travelCommentEntity == null) return ResponseDto.noExistComment();

            String user = travelCommentEntity.getUserId();
            boolean isUser = user.equals(userId);
            if(!isUser) return ResponseDto.noPermission();
            travelCommentRepository.deleteByTravelCommentNumber(travelCommentNumber);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }



>>>>>>> 242a098102e96732941b60a9bb4018fddb37203b
}
