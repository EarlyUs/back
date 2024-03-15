package com.earlyus.ewhanarae.domain.match.controller;

/*
- 1순위 : 시간 O 전공 O 도움 유형 O → 신청 가능자
- 2순위 : 시간 O 전공 O 도움 유형 X → 신청 가능자
- 3순위 : 시간 O 전공 X 도움 유형 O → 신청 가능자
- 4순위 : 시간 O 전공 X 도움 유형 X → 신청 가능자
- 5순위 : 시간 X → 대기자
* */

import com.earlyus.ewhanarae.domain.match.dto.CourseMatchResponses;
import com.earlyus.ewhanarae.domain.match.dto.MatchRequest;
import com.earlyus.ewhanarae.domain.match.dto.WingMatchResponse;
import com.earlyus.ewhanarae.domain.match.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
public class DisabledCourseController{
    private final MatchService matchService;

    @PostMapping("/wing")
    //@Operation(summary = "도우미 정보 보내면 날개 매칭 정보 반환")
    public ResponseEntity<WingMatchResponse> wingMatchResult(@RequestBody MatchRequest matchRequest){
        WingMatchResponse wingMatchResponse = matchService.findWingResult(matchRequest);
        return new ResponseEntity<>(wingMatchResponse, HttpStatus.OK);
    }

    @PostMapping("/course")
    //@Operation(summary = "도우미 정보 보내면 수업 매칭 정보 반환")
    public ResponseEntity<CourseMatchResponses> courseMatchResult(@RequestBody MatchRequest matchRequest){
        CourseMatchResponses courseMatchResponses = matchService.findCourseResult(matchRequest);
        return new ResponseEntity<>(courseMatchResponses, HttpStatus.OK);
    }
}
