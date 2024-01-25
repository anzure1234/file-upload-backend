package com.example.fileuploadprocess.controller;

import com.example.fileuploadprocess.dto.FileDTO;
import com.example.fileuploadprocess.dto.ResponseDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class AppController {

    @PostMapping
    public ResponseDTO<FileDTO> uploadFile(@RequestParam("content") MultipartFile fileDTO) {
        return new ResponseDTO("Received file", fileDTO.getOriginalFilename(), 200);
    }

    @GetMapping
    public ResponseDTO<String> get() {
        return new ResponseDTO("Hello World", "Hello World", 200);
    }
}
