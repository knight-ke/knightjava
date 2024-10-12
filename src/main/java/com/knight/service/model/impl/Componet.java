package com.knight.service.model.impl;

import com.knight.service.model.BaseModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
public class Componet extends BaseModelService {

    @Override
    public void delEntity() {
        log.info("delEntity");
    }

    @Override
    public void delRela() {

    }
}
