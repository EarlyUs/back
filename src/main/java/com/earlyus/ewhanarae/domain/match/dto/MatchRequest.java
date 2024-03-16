package com.earlyus.ewhanarae.domain.match.dto;

import com.earlyus.ewhanarae.domain.disabledCourse.domain.ClassTime;
import com.earlyus.ewhanarae.domain.match.domain.HelpType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class MatchRequest {
    private String name;
    private String studentNo;
    //private String college; //단과대학
    //private String faculty; //학부
    private String major; //전공
    private List<DoubleMajor> doubleMajorList; //부/복수전공
    private HelpType helpType; //도움 유형
    private List<ClassTime> classTimeList; //가능한 시간
}
