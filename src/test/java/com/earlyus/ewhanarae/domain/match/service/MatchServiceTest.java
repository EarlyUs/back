package com.earlyus.ewhanarae.domain.match.service;

import com.earlyus.ewhanarae.domain.disabledCourse.domain.ClassTime;
import com.earlyus.ewhanarae.domain.disabledCourse.domain.DisabilityLevelType;
import com.earlyus.ewhanarae.domain.disabledCourse.domain.DisabilityType;
import com.earlyus.ewhanarae.domain.disabledCourse.domain.DisabledCourse;
import com.earlyus.ewhanarae.domain.disabledCourse.repository.DisabledCourseRepository;
import com.earlyus.ewhanarae.domain.match.domain.HelpType;
import com.earlyus.ewhanarae.domain.match.dto.CourseMatchResponse;
import com.earlyus.ewhanarae.domain.match.dto.CourseMatchResponses;
import com.earlyus.ewhanarae.domain.match.dto.MatchRequest;
import com.earlyus.ewhanarae.domain.match.repository.WingRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MatchServiceTest {

    @InjectMocks
    private MatchService matchService;

    @Mock
    DisabledCourseRepository disabledCourseRepository;

    @Mock
    WingRepository wingRepository;

    @Test
    @DisplayName("장애학생 수강 과목 매칭 성공")
    public void disabledCourseMatchSuccess(){
        //given
        MatchRequest matchRequest = matchRequest();
        List<DisabledCourse> disabledCourseList = disabledCourseList();
        CourseMatchResponses courseMatchResponses = courseMatchResponses();

        //mocking
        given(disabledCourseRepository.findAll()).willReturn(disabledCourseList);

        //when
        CourseMatchResponses courseMatchResult = matchService.findCourseResult(matchRequest);

        //then
        assertEquals(courseMatchResponses.getCourseMatchResponses().size(),
                courseMatchResult.getCourseMatchResponses().size());

        for (int i=0; i<courseMatchResult.getCourseMatchResponses().size(); i++){
            CourseMatchResponse expected = courseMatchResponses.getCourseMatchResponses().get(i);
            CourseMatchResponse result = courseMatchResult.getCourseMatchResponses().get(i);
            assertEquals(expected.getClassTimeList(), result.getClassTimeList());
        }
    }

    private MatchRequest matchRequest() {
        return new MatchRequest("사회과교육", doubleMajorList(), HelpType.NOTETAKING, classTimeList());
    }

    private CourseMatchResponses courseMatchResponses() {
        CourseMatchResponse courseMatchResponse = new CourseMatchResponse(disabledCourse());
        List<CourseMatchResponse> courseMatchResponses = new ArrayList<>();
        courseMatchResponses.add(courseMatchResponse);
        return new CourseMatchResponses(courseMatchResponses);
    }

    private List<String> doubleMajorList() {
        List<String> doubleMajorList = new ArrayList<>();
        doubleMajorList.add("컴퓨터공학");
        doubleMajorList.add("경영학");
        return doubleMajorList;
    }

    private List<ClassTime> classTimeList() {
        List<ClassTime> classTimeList = new ArrayList<>();
        classTimeList.add(new ClassTime("화4", null));
        classTimeList.add(new ClassTime("화5", null));
        return classTimeList;
    }

    private List<DisabledCourse> disabledCourseList() {
        List<DisabledCourse> disabledCourseList = new ArrayList<>();
        disabledCourseList.add(disabledCourse());
        return disabledCourseList;
    }

    private DisabledCourse disabledCourse() {
        return new DisabledCourse(1, DisabilityType.DEAFNESS, DisabilityLevelType.MILD,
                "1234", "01", "courseName", "professor", "3", "3",
                "classRoom", "사회과교육", 1L, 1L, 0L, 0L, classTimeList());
    }
}