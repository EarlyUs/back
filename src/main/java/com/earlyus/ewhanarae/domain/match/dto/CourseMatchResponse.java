package com.earlyus.ewhanarae.domain.match.dto;

import com.earlyus.ewhanarae.domain.disabledCourse.domain.ClassTime;
import com.earlyus.ewhanarae.domain.disabledCourse.domain.DisabilityLevelType;
import com.earlyus.ewhanarae.domain.disabledCourse.domain.DisabilityType;
import com.earlyus.ewhanarae.domain.disabledCourse.domain.DisabledCourse;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class CourseMatchResponse {
    private DisabilityType disabilityType; //장애 유형(자폐성, 시각, 청각, 지체)
    private DisabilityLevelType disabilityLevel; //장애 급수(중증, 경증)
    private String courseNumber; //학수번호
    private String courseDivision; //분반
    private String courseName; //교과목명
    private String professor; //교수명
    private String credit; //학점
    private String duration; //시간
    private String classRoom; //교실
    private String major; //전공
    private Long noteTaking; //필기, 속타, 이동, 팀플
    private Long speedType; //속타
    private Long textBook; //교재 제작
    private Long mobility; //이동
    private List<ClassTime> classTimes; //수업 시간

    public CourseMatchResponse(DisabledCourse disabledCourse){
        this.disabilityType = disabledCourse.getDisabilityType();
        this.disabilityLevel = disabledCourse.getDisabilityLevel();
        this.courseNumber = disabledCourse.getCourseNumber();
        this.courseDivision = disabledCourse.getCourseDivision();
        this.courseName = disabledCourse.getCourseName();
        this.professor = disabledCourse.getProfessor();
        this.credit = disabledCourse.getCredit();
        this.duration = disabledCourse.getDuration();
        this.classRoom = disabledCourse.getClassRoom();
        this.major = disabledCourse.getMajor();
        this.noteTaking = disabledCourse.getNoteTaking();
        this.speedType = disabledCourse.getSpeedType();
        this.textBook = disabledCourse.getTextBook();
        this.mobility = disabledCourse.getMobility();
        this.classTimes = disabledCourse.getClassTimes();
    }
}
