package com.example.spring_day3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @GetMapping("upload")
    public String uploadForm(){
        return "upload-form";
    }

    @PostMapping("upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model){
        if(file.isEmpty()){
            model.addAttribute("message", "비어있는 파일입니다, 파일을 선택해주세요.");
            return "upload-form";
        }

        try {
            String savePath = System.getProperty("user.dir") + "/uploads/" + file.getOriginalFilename();
            File dest = new File(savePath);
            dest.getParentFile().mkdir();
            file.transferTo(dest);

            model.addAttribute("message" , "파일 업로드 성공!");
            model.addAttribute("filename" , file.getOriginalFilename());

        }catch (IOException e){
            e.printStackTrace();
            model.addAttribute("message", "파일 업로드 실패" + e.getMessage());
        }

        return "upload-success";
    }
}
