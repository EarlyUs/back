package com.earlyus.ewhanarae.domain.disabledCourse.domain;

public enum DisabilityLevelType {
    SEVERE("중증"),
    MILD("경증");

    private final String message;

    DisabilityLevelType(String message) {
        this.message = message;
    }
}
