package com.example.kioskproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadFileDto {
    //고객이 업로드한 파일명
    public String upLoadFileName;
    // 서버에 저장된 파일명
    public String storedFileName;
}
