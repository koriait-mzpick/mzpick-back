package com.koreait.mzpick_backend.service.implement.fashion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.common.object.fashion.FashionVote;
import com.koreait.mzpick_backend.dto.request.fashion.PostFashionlVoteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionVoteDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionVoteListResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionVoteTotalCountResponseDto;
import com.koreait.mzpick_backend.entity.fashion.FashionVoteEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionVoteResultEntity;
import com.koreait.mzpick_backend.entity.fashion.resultSet.GetFashionVoteResultSet;
import com.koreait.mzpick_backend.repository.fashion.FashionVoteRepository;
import com.koreait.mzpick_backend.repository.fashion.FashionVoteResultRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.fashion.FashionVoteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FashionVoteServiceImplement implements FashionVoteService {
    private final UserRepository userRepository;
    private final FashionVoteRepository fashionVoteRepository;
    private final FashionVoteResultRepository fashionVoteResultRepository;

    @Override
    public ResponseEntity<? super GetFashionVoteListResponseDto> getFashionVoteList() {
        List<FashionVote> fashionVotes = new ArrayList<>();
        try {
            List<FashionVoteEntity> fashionVoteEntitys = fashionVoteRepository.findAll();
            for (FashionVoteEntity fashionVoteEntity : fashionVoteEntitys) {
                Integer fashionVoteNumber = fashionVoteEntity.getFashionVoteNumber();
                List<FashionVoteResultEntity> fashionVoteResultEntitys = fashionVoteResultRepository
                        .findByFashionVoteNumber(fashionVoteNumber);
                FashionVote fashionVote = new FashionVote(fashionVoteEntity, fashionVoteResultEntitys);
                fashionVotes.add(fashionVote);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetFashionVoteListResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetFashionVoteDetailResponseDto> getTravelVote(Integer fashionVoteNumber) {
        FashionVote fashionVote = null;
        try {
            FashionVoteEntity fashionVoteEntity = fashionVoteRepository.findByFashionVoteNumber(fashionVoteNumber);
            if(fashionVoteEntity == null) return ResponseDto.noExistBoard();

            List<FashionVoteResultEntity> fashionVoteResultEntitys = fashionVoteResultRepository.findByFashionVoteNumber(fashionVoteNumber);
            fashionVote = new FashionVote(fashionVoteEntity, fashionVoteResultEntitys);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetFashionVoteListResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> postFashionVote(PostFashionlVoteRequestDto dto, String userId) {
        try {
            boolean existedUser = userRepository.existsByUserId(userId);
            if(!existedUser) return ResponseDto.noExistUserId();

            FashionVoteEntity fashionVoteEntity = new FashionVoteEntity(dto, userId);
            fashionVoteRepository.save(fashionVoteEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteFashionVote(Integer fashionVoteNumber, String userId) {
        try {
            FashionVoteEntity fashionVoteEntity = fashionVoteRepository.findByFashionVoteNumber(fashionVoteNumber);
            if(fashionVoteEntity == null) return ResponseDto.noExistBoard();

            String user = fashionVoteEntity.getUserId();
            boolean isUser = user.equals(userId);
            if(!isUser) return ResponseDto.noPermission();

            fashionVoteRepository.delete(fashionVoteEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> clickVote(Integer selectNumber, Integer fashionVoteNumber, String userId) {
        try {
            FashionVoteEntity fashionVoteEntity = fashionVoteRepository.findByFashionVoteNumber(fashionVoteNumber);
            if(fashionVoteEntity == null) ResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByUserId(userId);
            if(!existedUser) return ResponseDto.noExistUserId();

            String fashionVoteResultChoice  = selectNumber == 1? fashionVoteEntity.getFashionVoteChoice1() :fashionVoteEntity.getFashionVoteChoice2();
            FashionVoteResultEntity fashionVoteResultEntity = new FashionVoteResultEntity(userId, fashionVoteNumber, fashionVoteResultChoice);
            boolean isClick = fashionVoteResultRepository.existsByUserIdAndFashionVoteNumber(userId, fashionVoteNumber);
            if(isClick){
                fashionVoteResultRepository.delete(fashionVoteResultEntity);
            }else{
                fashionVoteResultRepository.save(fashionVoteResultEntity);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetFashionVoteTotalCountResponseDto> totalVote(Integer fashionVoteNumber) {
        List<GetFashionVoteResultSet> resultSets = new ArrayList<>();
        try{
            resultSets = fashionVoteResultRepository.totalVoteResultCount(fashionVoteNumber);
        } catch(Exception exception) {
            exception.printStackTrace();;
            return ResponseDto.databaseError();
        }
        return GetFashionVoteTotalCountResponseDto.success(resultSets);
    }

}
