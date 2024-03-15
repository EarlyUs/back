package com.earlyus.ewhanarae.domain.disabledCourse.domain;

public enum DisabilityType {
    SPECTRUM("자폐"),
    BLINDNESS("시각장애"),
    DEAFNESS("청각장애"),
    PHYSICAL("지체장애");

    private final String message;

    DisabilityType(String message) {
        this.message = message;
    }
}
