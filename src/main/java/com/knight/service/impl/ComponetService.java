package com.knight.service.impl;

import com.knight.service.BaseModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ComponetService extends BaseModelService {

    @Override
    public void delEntity() {
        log.info("delEntity");
    }

    @Override
    public void delRela() {

    }
}
