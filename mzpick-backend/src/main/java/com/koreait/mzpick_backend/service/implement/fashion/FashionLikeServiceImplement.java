package com.koreait.mzpick_backend.service.implement.fashion;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.fashion.FashionEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionLikeEntity;
import com.koreait.mzpick_backend.repository.fashion.FashionLikeRepository;
import com.koreait.mzpick_backend.repository.fashion.FashionRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.fashion.FashionLikeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FashionLikeServiceImplement implements FashionLikeService {
    
    private final FashionRepository fashionRepository;
    private final UserRepository userRepository;
    private final FashionLikeRepository fashionLikeRepository;

    //put 해당 여행지 게시글 좋아요 누르기 및 좋아요 취소하기 서비스 //
    @Override
    public ResponseEntity<ResponseDto> putLike(Integer fashionNumber, String userId) {
        try {
            FashionEntity fashionEntity = fashionRepository.findByFashionNumber(fashionNumber);
            if(fashionEntity == null) return ResponseDto.noExistBoard();
            boolean existsByUserId = userRepository.existsByUserId(userId);
            if(!existsByUserId) return ResponseDto.noExistUserId();

            boolean isLike = fashionLikeRepository.existsByUserIdAndFashionNumber(userId, fashionNumber);
            FashionLikeEntity fashionLikeEntity = new FashionLikeEntity(fashionNumber, userId);

            if(isLike){
                fashionLikeRepository.delete(fashionLikeEntity);
                fashionEntity.downLikeCount();
            }else{
                fashionLikeRepository.save(fashionLikeEntity);
                fashionEntity.upLikeCount();
            }
            fashionRepository.save(fashionEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

}