package com.earlyus.ewhanarae.domain.match.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CourseMatchResponses {
    List<CourseMatchResponse> courseMatchResponses;
}
