package com.koreait.mzpick_backend.service.implement.keyword;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.ArrayList;

import com.koreait.mzpick_backend.dto.request.keyword.PostKeywordWriteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.keyword.GetKeywordListResponseDto;
import com.koreait.mzpick_backend.entity.keyword.KeywordEntity;
import com.koreait.mzpick_backend.repository.keyword.keywordRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.keyword.KeywordService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KeyWordServiceImplement implements KeywordService{
    
    private final keywordRepository keywordRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetKeywordListResponseDto> getKeyword() {

        List<KeywordEntity> keywordEntities  = new ArrayList<>();
        
        try {
            keywordEntities = keywordRepository.findAll();

        } catch (Exception exception) {
            exception.printStackTrace();
          return ResponseDto.databaseError();
        }
        
        return GetKeywordListResponseDto.success(keywordEntities);
    }

    @Override
    public ResponseEntity<ResponseDto> postKeyword(PostKeywordWriteRequestDto dto, String userId) {
        
        try {

            boolean isUser = userRepository.existsByUserId(userId);
            if (!isUser) return ResponseDto.noExistUserId();

            
            
            KeywordEntity keywordEntity = new KeywordEntity(dto, userId);
            keywordRepository.save(keywordEntity);

           
            

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    
    
}
