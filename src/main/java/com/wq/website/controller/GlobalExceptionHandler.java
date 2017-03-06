package com.wq.website.controller;

import com.wq.website.exception.TipException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by BlueT on 2017/3/4.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = TipException.class)
    public String tipException(){
        return "/comm/error_500";
    }


    @ExceptionHandler(value = Exception.class)
    public String exception(){
        return "/comm/error_404";
    }
}
