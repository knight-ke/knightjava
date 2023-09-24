package com.knight.enums;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;


//@SpringBootTest
@Slf4j
class ColorTest {

    @BeforeEach
    void setUp() {
        log.info("setup");
    }

    @AfterEach
    void tearDown() {
        log.info("tearDown");
    }

    @Test
    void values() {
        log.info("values: " + Arrays.toString(Color.values()));
    }

    @Test
    void print() {
        log.info(String.valueOf(Color.BLUE));
        System.out.println(Color.BLUE);
        log.info(Color.BLUE.name());
        log.info(Color.BLUE.toString());
        log.info(String.valueOf(Color.BLUE.compareTo(Color.RED)));
    }

    @Test
    void valueOf() {
        log.info("valueof: " + Color.valueOf("RED"));
        log.info("valueof: " + Color.valueOf("BLUE"));
    }

    @Test
    void switchTest() {
        Color color = Color.BLUE;
        switch (color) {
            case BLUE:
                log.info("blue");
                break;
            case GREEN:
                log.info("green");
                break;
            case RED:
                log.info("red");
                break;
            default:
                log.info("unkown");
        }
    }
    @Test
    void ordinal() {
        log.info("ordinal: " + Color.RED.ordinal());
        log.info("ordinal: " + Color.GREEN.ordinal());
        log.info("ordinal: " + Color.BLUE.ordinal());
    }
}