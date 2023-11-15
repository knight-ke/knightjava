package com.knight.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class ForwardController {
    @RequestMapping("/eSight")
    public void eSight(HttpServletRequest request, HttpServletResponse response) {
        log.info("eSight++++++++++++++++++++++++++");
        request.getServletDis
    }
}
