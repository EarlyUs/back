package com.earlyus.ewhanarae.domain.match.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class CourseMatchResponses {
    List<CourseMatchResponse> courseMatchResponses;
}
