package com.earlyus.ewhanarae.domain.match.controller;

import com.earlyus.ewhanarae.domain.match.dto.CourseMatchResponses;
import com.earlyus.ewhanarae.domain.match.dto.MatchRequest;
import com.earlyus.ewhanarae.domain.match.dto.WingMatchResponse;
import com.earlyus.ewhanarae.domain.match.service.MatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Match", description = "매칭 관련 URI 입니다.")
@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchController {
    private final MatchService matchService;

    @Operation(summary = "날개 매칭", description = "도우미 정보를 받아 매칭된 날개 정보를 반환합니다.")
    @PostMapping("/wing")
    //@Operation(summary = "도우미 정보 보내면 날개 매칭 정보 반환")
    public ResponseEntity<WingMatchResponse> wingMatchResult(@RequestBody MatchRequest matchRequest){
        WingMatchResponse wingMatchResponse = matchService.findWingResult(matchRequest);
        return new ResponseEntity<>(wingMatchResponse, HttpStatus.OK);
    }

    @Operation(summary = "수업 매칭", description = "도우미 정보를 받아 매칭된 수업 리스트를 반환합니다.")
    @PostMapping("/course")
    //@Operation(summary = "도우미 정보 보내면 수업 매칭 정보 반환")
    public ResponseEntity<CourseMatchResponses> courseMatchResult(@RequestBody MatchRequest matchRequest){
        CourseMatchResponses courseMatchResponses = matchService.findCourseResult(matchRequest);
        return new ResponseEntity<>(courseMatchResponses, HttpStatus.OK);
    }
}
