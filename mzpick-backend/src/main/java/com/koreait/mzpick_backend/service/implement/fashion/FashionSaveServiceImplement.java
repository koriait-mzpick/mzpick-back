package com.koreait.mzpick_backend.service.implement.fashion;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.fashion.FashionEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionSaveEntity;
import com.koreait.mzpick_backend.repository.fashion.FashionRepository;
import com.koreait.mzpick_backend.repository.fashion.FashionSaveRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.fashion.FashionSaveService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FashionSaveServiceImplement implements FashionSaveService{
    private final FashionRepository fashionRepository;
    private final UserRepository userRepository;
    private final FashionSaveRepository fashionSaveRepository;

    @Override
    public ResponseEntity<ResponseDto> postSave(Integer fashionNumber, String userId) {

        try {
            FashionEntity fashionEntity = fashionRepository.findByFashionNumber(fashionNumber);
            if(fashionEntity == null) return ResponseDto.noExistBoard();
            boolean existsByUserId = userRepository.existsByUserId(userId);
            if(!existsByUserId) return ResponseDto.noExistUserId();

            boolean isSave = fashionSaveRepository.existsByUserIdAndFashionNumber(userId, fashionNumber);

            FashionSaveEntity fashionSaveEntity = new FashionSaveEntity(fashionNumber, userId);

            if (isSave) {
                fashionSaveRepository.delete(fashionSaveEntity);
            }else{
                fashionSaveRepository.save(fashionSaveEntity);
            }
            fashionRepository.save(fashionEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }
}
