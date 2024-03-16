package com.earlyus.ewhanarae.domain.disabledCourse.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassTime classTime = (ClassTime) o;
        return Objects.equals(time, classTime.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time);
    }
}
