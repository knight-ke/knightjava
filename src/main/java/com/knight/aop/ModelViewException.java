package com.knight.aop;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public class ModelViewException extends RuntimeException{
    private int code;
    private String msg;
    public static ModelViewException transfer(CustomeException e) {
        return new ModelViewException(e.hashCode(), e.getMessage());
    }

    public ModelAndView viewExceptionHandler(HttpServletRequest req, ModelViewException e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", req.getRequestURL());
        modelAndView.setViewName("error");
        return modelAndView;
    }
    private ModelViewException(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    int getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }
}
