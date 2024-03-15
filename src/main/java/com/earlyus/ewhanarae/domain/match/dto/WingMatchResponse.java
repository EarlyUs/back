package com.earlyus.ewhanarae.domain.match.dto;

import com.earlyus.ewhanarae.domain.match.domain.Wing;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class WingMatchResponse {
    //날개 이름, 설명, 이미지
    private String name;
    private String description;
    private String img;

    public WingMatchResponse(Wing wing){
        this.name = wing.getName();
        this.description = wing.getDescription();
        this.img = wing.getImg();
    }
}
