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
public class ClassTime {
    @Id
    @Column(name="time_id")
    private String time; //월1 ~ 금7
    @ManyToMany(mappedBy = "classTimes", fetch = FetchType.LAZY)
    private List<DisabledCourse> disabledCourses;
}
