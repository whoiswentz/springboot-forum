package com.vinicios.forum.controller.dto;

public class TokenDto {

    private final String toke;
    private final String type;

    public TokenDto(String toke, String type) {
        this.toke = toke;
        this.type = type;
    }

    public String getToke() {
        return toke;
    }

    public String getType() {
        return type;
    }
}
