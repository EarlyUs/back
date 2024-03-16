package com.earlyus.ewhanarae.domain.match.domain;

public enum HelpType {
    NOTETAKING("필기"),
    SPEEDTYPE("속타"),
    TEXTBOOK("교재 제작"),
    MOBILITY("이동 지원");

    private final String message;

    HelpType(String message) {
        this.message = message;
    }
}
