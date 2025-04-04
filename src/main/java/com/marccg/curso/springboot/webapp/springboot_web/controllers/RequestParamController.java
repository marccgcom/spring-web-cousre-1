package com.marccg.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.marccg.curso.springboot.webapp.springboot_web.Models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/params")

public class RequestParamController {
    
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue="No Message.", name = "message") String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/bar")
    public ParamDto bar(@RequestParam() String text, @RequestParam Integer code) {
        ParamDto params = new ParamDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }
    
    @GetMapping("/request")
    public ParamDto request(HttpServletRequest request) {
        ParamDto params = new ParamDto();
        Integer code = 0;
        try{
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e){
            code = null;
        }
        params.setMessage(request.getParameter("text"));
        params.setCode(code);
        return params;
    }
    
    
}
