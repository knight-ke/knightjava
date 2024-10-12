package com.knight.mapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Mapper {

    public void add(String name){
        log.info(name);
    }
}
