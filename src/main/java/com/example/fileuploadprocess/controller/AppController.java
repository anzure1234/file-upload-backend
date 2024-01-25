package com.example.fileuploadprocess.controller;

import com.example.fileuploadprocess.dto.FileDTO;
import com.example.fileuploadprocess.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/file")
@Slf4j
public class AppController {

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseDTO<List<FileDTO>> uploadFiles(@RequestParam("content") List<MultipartFile> files) {
        files.forEach(file -> System.out.println("run here"));
        List<FileDTO> fileDTOs = files.stream()
                .map(file -> new FileDTO(file.getOriginalFilename(), file.getContentType(), file))
                .collect(Collectors.toList());
//        System.out.println("Got a run");
        log.info("Received files: {}", fileDTOs);

        return new ResponseDTO<>("Received files", fileDTOs, 200);
    }

    @GetMapping
    public ResponseDTO<String> get() {
        return new ResponseDTO<>("Hello World", "Hello World", 200);
    }
}
