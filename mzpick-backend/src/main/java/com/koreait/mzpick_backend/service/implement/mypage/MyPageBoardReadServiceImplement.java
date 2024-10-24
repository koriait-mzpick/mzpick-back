package com.koreait.mzpick_backend.service.implement.mypage;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.auth.UserEntity;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.mypage.MyPageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyPageServiceImplement implements MyPageService{
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseDto> userDelete(String userId) {

        
        try {
            UserEntity userEntity = userRepository.findByUserId(userId);
            if (userEntity == null) return ResponseDto.noExistBoard();
            
            String user = userEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser) return ResponseDto.noExistUserId();

            userRepository.delete(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> userBoardReadTravel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userBoardReadTravel'");
    }

    @Override
    public ResponseEntity<ResponseDto> userBoardReadFood() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userBoardReadFood'");
    }

    @Override
    public ResponseEntity<ResponseDto> userBoardReadStay() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userBoardReadStay'");
    }

    @Override
    public ResponseEntity<ResponseDto> userBoardReadFashion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userBoardReadFashion'");
    }

        
}
