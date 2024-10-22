package com.koreait.mzpick_backend.service.implement.travel_vote;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelVoteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.travel.TravelVoteEntity;
import com.koreait.mzpick_backend.repository.travel.TravelVoteRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.dto.request.travel.PostTravelVoteClickRequestDto;
import com.koreait.mzpick_backend.service.travel_vote.TravelVoteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelVoteServiceImplement implements TravelVoteService {
    private final UserRepository userRepository;
    private final TravelVoteRepository travelVoteRepository;

    @Override
    public ResponseEntity<ResponseDto> postTravelVote(PostTravelVoteRequestDto dto, String userId) {
        try {
            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser)
                return ResponseDto.noExistUserId();

            TravelVoteEntity travelVoteEntity = new TravelVoteEntity(dto, userId);
            travelVoteRepository.save(travelVoteEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteTravelVote(Integer travelVoteNumber, String userId) {

        try {
            TravelVoteEntity travelVoteEntity = travelVoteRepository.findByTravelVoteNumber(travelVoteNumber);
            if (travelVoteEntity == null) return ResponseDto.noExistBoard();

            String user = travelVoteEntity.getUserId();
            boolean isUser = user.equals(userId);
            if (!isUser) return ResponseDto.noPermission();

            travelVoteRepository.delete(travelVoteEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();

    }
    public ResponseEntity<ResponseDto> getVote() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVote'");
    }


    @Override
    public ResponseEntity<ResponseDto> clickVote(PostTravelVoteClickRequestDto dto, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clickVote'");
    }

    @Override
    public ResponseEntity<ResponseDto> totalVote(Integer travelVoteNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'totalVote'");
    }

}
