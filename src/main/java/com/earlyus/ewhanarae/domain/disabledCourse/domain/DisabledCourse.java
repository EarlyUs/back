package com.earlyus.ewhanarae.domain.disabledCourse.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class DisabledCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private DisabilityType disabilityType; //장애 유형(자폐성, 시각, 청각, 지체)

    @Enumerated(EnumType.STRING)
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="course_class",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "time_id"))
    private List<ClassTime> classTimes;
}
