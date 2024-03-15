package com.earlyus.ewhanarae.domain.disabledCourse.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ClassTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Day day; //요일(mon, tue, wed, thu, fri, sat, sun)
    private Integer period; //시간(1~7)
}
