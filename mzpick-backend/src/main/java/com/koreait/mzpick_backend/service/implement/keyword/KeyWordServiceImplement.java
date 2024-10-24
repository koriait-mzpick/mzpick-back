package com.koreait.mzpick_backend.service.implement.keyword;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.request.keyword.PostKeywordWriteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.keyword.GetKeywordListResponseDto;
import com.koreait.mzpick_backend.entity.keyword.KeywordEntity;
import com.koreait.mzpick_backend.repository.keyword.keywordRepository;
import com.koreait.mzpick_backend.repository.resultSet.GetKeywordResultset;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.keyword.KeywordService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Service
@RequiredArgsConstructor
@Log
public class KeyWordServiceImplement implements KeywordService{
    
    private final keywordRepository keywordRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetKeywordListResponseDto> getKeyword() {

        List<GetKeywordResultset> keywordEntities  = new ArrayList<>();
        

        try {

            String pattern = "yyyy-MM-dd";
            
            //현재 날짜
            Date now = Calendar.getInstance().getTime();
            SimpleDateFormat nowDateFormat = new SimpleDateFormat(pattern);
            String nowDate = nowDateFormat.format(now);

            Date nowLocalDate = new SimpleDateFormat(pattern).parse(nowDate);
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern);
            Calendar calendar = Calendar.getInstance();
            
            // 만료 주차 구하기 코드
            calendar.setTime(nowLocalDate);

            calendar.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
            String startDate = simpleDateFormat1.format(calendar.getTime());
            
            calendar.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
            String endDate = simpleDateFormat2.format(calendar.getTime());
            
            keywordEntities = keywordRepository.getLanking(startDate, endDate);


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
