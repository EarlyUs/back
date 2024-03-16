package com.earlyus.ewhanarae.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    WING_NOT_FOUND(HttpStatus.NOT_FOUND, "일치하는 날개가 존재하지 않습니다."),
    COURSE_NOT_FOUND(HttpStatus.NOT_FOUND, "일치하는 수강이 존재하지 않습니다."),
    ;

    private final HttpStatus status;
    private final String message;
}
