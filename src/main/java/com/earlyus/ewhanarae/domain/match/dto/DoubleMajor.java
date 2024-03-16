package com.earlyus.ewhanarae.domain.match.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class DoubleMajor {
    //private String college; //단과대학
    //private String faculty; //학부
    private String major; //전공
}
