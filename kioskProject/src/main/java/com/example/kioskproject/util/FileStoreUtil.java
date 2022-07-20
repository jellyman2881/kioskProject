package com.example.kioskproject.util;

import com.example.kioskproject.dto.UploadFileDto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class FileStoreUtil {

    @Value("${file.dir}")
    private String fileDir;

    public String getFullPath(String filename) {
        return fileDir + filename;
    }

    public UploadFileDto storeFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) return null;

        // 사용자가 저장한 파일명
        String uploadFileName = multipartFile.getOriginalFilename();
        // 서버에 저장하는 파일명
        String storeFileName = createStoreFileName(uploadFileName);
        multipartFile.transferTo(new File(getFullPath(storeFileName)));

        return new UploadFileDto(uploadFileName, storeFileName);
    }

    private String createStoreFileName(String uploadFileName) {
        String uuid = UUID.randomUUID().toString();
        String ext = extractExt(uploadFileName);
        return uuid + "." + ext;
    }

    private String extractExt(String uploadFileName) {
        int pos = uploadFileName.lastIndexOf(".");
        return uploadFileName.substring(pos + 1);
    }
}
