package com.murattanriverdi.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/message")
    @ResponseBody
    public String getMessage(){
        return "İleti";
    }



}
