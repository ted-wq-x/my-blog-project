package com.wq.website.controller;

import com.wq.website.exception.TipException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by BlueT on 2017/3/4.
 */
@ControllerAdvice
public class GlobalExceptionHandler  {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = TipException.class)
    public ModelAndView tipException(Exception e) {
        LOGGER.error("find exception:e={}", e.getMessage());
        LOGGER.trace(e.getMessage(), e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("comm/error_500");
        return modelAndView;
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception e) {
        LOGGER.error("find exception:e={}", e.getMessage());
        LOGGER.trace(e.getMessage(),e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("comm/error_404");
        return modelAndView;
    }
}
