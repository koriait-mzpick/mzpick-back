package com.koreait.mzpick_backend.service.implement.travel;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.mzpick_backend.dto.request.travel.PatchTravelRequestDto;
import com.koreait.mzpick_backend.dto.request.travel.PostTravelRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.entity.travel.TravelHashtagEntity;
import com.koreait.mzpick_backend.repository.travel.TravelHashtagRepository;
import com.koreait.mzpick_backend.repository.travel.TravelRepository;
import com.koreait.mzpick_backend.repository.user.UserRepository;
import com.koreait.mzpick_backend.service.travel.TravelService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelServiceImplement implements TravelService {
    
    private final TravelRepository travelRepository;
    private final TravelHashtagRepository travelHashtagRepository;

    // @Value("${file.path}")
    // private String filePath;
    // @Value("${file.url}")
    // private String fileUrl;

    // @Override
    // public ResponseEntity<ResponseDto> PostTravel(PostTravelRequestDto dto, List<MultipartFile> Travelfiles) {
    //     List<String> travelFiles = new ArrayList<>();
    //     for (MultipartFile file : Travelfiles) {
    //         if (file.isEmpty()) return null;

    //         String originalFileName = file.getOriginalFilename();

    //         String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
    //         String uuid = UUID.randomUUID().toString();

    //         String saveFileName = uuid + extension;
    //         String saveFilePath = filePath + saveFileName;

    //         File dest = new File(saveFilePath);
    //         file.transferTo(dest);

    //     }

    // }

    @Override
    public ResponseEntity<ResponseDto> postTravel(PostTravelRequestDto dto, String userId) {
        try {
            TravelEntity travelEntity = new TravelEntity(dto, userId);
            travelRepository.save(travelEntity);

            Integer travelNumber = travelEntity.getTravelNumber();

            List<String> travelHashtagContentList = dto.getTravelHashtagContentList();
            List<TravelHashtagEntity> travelHashtagEntities = new ArrayList<>();
            for (String travelHashtagContent: travelHashtagContentList) {
                TravelHashtagEntity travelHashtagEntity = new TravelHashtagEntity(travelNumber, travelHashtagContent);
                travelHashtagEntities.add(travelHashtagEntity);
            }
            travelHashtagRepository.saveAll(travelHashtagEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> patchTravel(PatchTravelRequestDto dto, Integer travelNumber, String userID) {
        try {

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteTravel(Integer travelNumber, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTravel'");
    }


}
