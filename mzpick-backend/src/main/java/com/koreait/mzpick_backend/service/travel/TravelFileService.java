package com.koreait.mzpick_backend.service.travel;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface TravelFileService {
    
    String upload(MultipartFile file);
    Resource getFile(String fileName);
}
