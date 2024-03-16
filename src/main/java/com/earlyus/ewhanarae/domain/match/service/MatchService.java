package com.earlyus.ewhanarae.domain.match.service;

import com.earlyus.ewhanarae.domain.disabledCourse.domain.ClassTime;
import com.earlyus.ewhanarae.domain.disabledCourse.domain.DisabledCourse;
import com.earlyus.ewhanarae.domain.disabledCourse.repository.DisabledCourseRepository;
import com.earlyus.ewhanarae.domain.match.domain.Wing;
import com.earlyus.ewhanarae.domain.match.dto.CourseMatchResponse;
import com.earlyus.ewhanarae.domain.match.dto.CourseMatchResponses;
import com.earlyus.ewhanarae.domain.match.dto.MatchRequest;
import com.earlyus.ewhanarae.domain.match.dto.WingMatchResponse;
import com.earlyus.ewhanarae.domain.match.repository.WingRepository;
import com.earlyus.ewhanarae.global.exception.CustomException;
import com.earlyus.ewhanarae.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MatchService {
    private final WingRepository wingRepository;
    private final DisabledCourseRepository disabledCourseRepository;

    //도우미의 날개 타입 정보 반환
    public WingMatchResponse findWingResult(MatchRequest matchRequest) {
        Long majorMatched = disabledCourseRepository.findByMajor(matchRequest.getMajor()).isPresent() ? 1L : 0L;
        List<Wing> wingMatchResponses = wingRepository.findAll().stream()
                .filter(w -> w.getMajorMatch().equals(majorMatched) && w.getHelpType().equals(matchRequest.getHelpType()))
                .toList();

        if(wingMatchResponses.isEmpty()){
            throw new CustomException(ErrorCode.WING_NOT_FOUND);
        }

        return new WingMatchResponse(wingMatchResponses.get(0));
    }

    /* 장애학생의 수업 전체 중 matchRequest와 일치하는 것 찾기
        도우미와 일치하는 수업 리스트 반환
      - 1순위 : 시간 O 전공 O 도움 유형 O → 신청 가능자
      - 2순위 : 시간 O 전공 O 도움 유형 X → 신청 가능자
      - 3순위 : 시간 O 전공 X 도움 유형 O → 신청 가능자
      - 4순위 : 시간 O 전공 X 도움 유형 X → 신청 가능자
      - 5순위 : 시간 X → 대기자
    * */
    public CourseMatchResponses findCourseResult(MatchRequest matchRequest) {
        List<DisabledCourse> disabledCourses = disabledCourseRepository.findAll()
                .stream().filter(d -> {
                    return new HashSet<>(matchRequest.getClassTimeList()).containsAll(d.getClassTimes());
                })
                .toList();

        if(disabledCourses.isEmpty()){
            throw new CustomException(ErrorCode.COURSE_NOT_FOUND);
        }
        return new CourseMatchResponses(disabledCourses.stream().map(CourseMatchResponse::new).toList());
    }
}
