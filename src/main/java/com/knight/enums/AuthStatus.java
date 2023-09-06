package com.knight.enums;

enum AuthStatus {

    Test(1, "");

    private int code;
    private String info;

    AuthStatus(int code, String info) {
        this.code = code;
        this.info = info;
    }


}