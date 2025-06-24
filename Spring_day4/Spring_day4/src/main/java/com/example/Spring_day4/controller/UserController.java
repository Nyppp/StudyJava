package com.example.Spring_day4.controller;

import com.example.Spring_day4.model.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//@RestController
//공통적인 경로는, 메서드 마다 경로를 써도 되지만 더 간결하게 사용하기 위해 클래스 어노테이션에 미리 경로 명시
//@RequestMapping("/api")

@Controller
public class UserController {

    //클래스 자체에 어노테이션을 주지 않고, 메서드 마다 다르게 주어 한 컨트롤러에서 렌더링, api 처리 가능
    @GetMapping("/form")
    public String showForm(Model model){
        return "form";
    }

    //---- 직접 스트링으로 리턴해주는 경우 ----//
//    @PostMapping("/api/user")
//    @ResponseBody
//    //폼 요청으로 들어온 JSON객체를 DTO 객체로 매핑 > RequestBody의 역할
//    public String processUser(@RequestBody User user){
//        if(user.getAge() >= 18){
//            return "안녕하세요 " + user.getName() + "님, 성인입니다.";
//        }else{
//            return "안녕하세요 " + user.getName() + "님, 미성년자입니다.";
//        }
//    }

    //---- ResponseEntity로 리턴해주는 경우 ----//
    @PostMapping("/api/user")
    @ResponseBody
    public ResponseEntity<String> processUser(@RequestBody User user){
        String message;
        
        //http 상태와 메세지를 함께 전송하여 에러 핸들링 등 사용가능
        if(user.getAge() >= 18){
            message = "안녕하세요 " + user.getName() + "님, 성인입니다.";
            //http 200
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }else{
            message = "안녕하세요 " + user.getName() + "님, 미성년자입니다.";
            //http 400
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }
}
