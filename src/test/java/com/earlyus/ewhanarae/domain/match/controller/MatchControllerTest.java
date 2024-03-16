package com.earlyus.ewhanarae.domain.match.controller;

import com.earlyus.ewhanarae.domain.disabledCourse.domain.ClassTime;
import com.earlyus.ewhanarae.domain.disabledCourse.domain.DisabilityLevelType;
import com.earlyus.ewhanarae.domain.disabledCourse.domain.DisabilityType;
import com.earlyus.ewhanarae.domain.disabledCourse.domain.DisabledCourse;
import com.earlyus.ewhanarae.domain.match.domain.HelpType;
import com.earlyus.ewhanarae.domain.match.dto.CourseMatchResponse;
import com.earlyus.ewhanarae.domain.match.dto.CourseMatchResponses;
import com.earlyus.ewhanarae.domain.match.dto.MatchRequest;
import com.earlyus.ewhanarae.domain.match.dto.WingMatchResponse;
import com.earlyus.ewhanarae.domain.match.service.MatchService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class MatchControllerTest {
    @InjectMocks
    private MatchController matchController;

    @Mock
    private MatchService matchService;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(matchController).build();
    }

    @Test
    @DisplayName("장애학생 수강 과목 매칭 성공")
    public void disabledCourseMatchSuccess() throws Exception {
        //given
        MatchRequest request = matchRequest();
        CourseMatchResponses response = courseMatchResponses();

        doReturn(response).when(matchService).findCourseResult(any(MatchRequest.class));

        //when
        ResultActions resultActions = mockMvc.perform(
            MockMvcRequestBuilders.post("/match/course")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new Gson().toJson(request))
        );

        //then
        MvcResult mvcResult = resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("courseMatchResponses", response.getCourseMatchResponses()).exists())
                .andReturn();
    }

    private MatchRequest matchRequest() {
        return new MatchRequest("사회과교육", doubleMajorList(), HelpType.NOTETAKING, classTimeList());
    }

    private CourseMatchResponses courseMatchResponses() {
        List<CourseMatchResponse> courseMatchResponses = new ArrayList<>();
        courseMatchResponses.add(new CourseMatchResponse(disabledCourse()));
        return new CourseMatchResponses(courseMatchResponses);
    }

    private WingMatchResponse wingMatchResponse() {
        return new WingMatchResponse("유형1", "유형 설명1", "유형 상세 설명", "이미지");
    }

    private DisabledCourse disabledCourse() {
        return new DisabledCourse(1, DisabilityType.DEAFNESS, DisabilityLevelType.MILD,
                "1234", "01", "courseName", "professor", "3", "3",
                "classRoom", "사회과교육", 1L, 1L, 0L, 0L, classTimeList());
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
}