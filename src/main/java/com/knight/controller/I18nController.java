package com.knight.controller;

import com.knight.Utils.LocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class I18nController {

    @GetMapping("getmsg")
    public String language() {
        log.info("getmsg");
        String message = LocalUtil.get("user.appname");  //调用
        return message;
    }

    @GetMapping("putmsg")
    public String lan1(@RequestParam String lang) {
        log.info("lang: " + lang);
        String message = LocalUtil.get("user.appname");  //调用
        return message;
    }
}
