package com.fundamentosplatzi.springboot.fundamentos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("test")
public class TestController {
    @ResponseBody
    @RequestMapping("/")
    public ResponseEntity<String> function() {
      return  new ResponseEntity<>("Hola controller", HttpStatus.OK);
    }
}
