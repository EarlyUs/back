package com.earlyus.ewhanarae.domain.disabledCourse.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class DisabledCourse {
    //장애유형 장애급수 학수번호 분반 교과목명 교수명 학점 교실 활동내용
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private DisabilityType disabilityType; //장애 유형(자폐성, 시각, 청각, 지체)
    private DisabilityLevelType disabilityLevel; //장애 급수(중증, 경증)
    private String courseNumber; //학수번호
    private String courseDivision; //분반
    private String courseName; //교과목명
    private String professor; //교수명
    private String credit; //학점
    private String classRoom; //교실
    private String major; //전공
    private Boolean noteTaking; //필기, 속타, 이동, 팀플
    private Boolean speedType; //속타
    private Boolean textBook; //교재 제작
    private Boolean mobility; //이동
    @OneToMany(mappedBy = "disabled_course")
    private ArrayList<ClassTime> classTimes;
}
