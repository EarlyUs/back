package com.earlyus.ewhanarae.domain.match.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Wing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long majorMatch; //일치하는 전공 존재 여부
    @Enumerated(EnumType.STRING)
    private HelpType helpType;  //도움 유형
    private String name;  //날개 유형 이름
    private String description; //날개 유형 설명
    private String detailDescription; //날개 유형 상세 설명
    private String img; //날개 결과 이미지
}
