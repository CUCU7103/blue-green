package org.security.deploytest.service;

import lombok.Builder;
import org.security.deploytest.domain.BoardEntity;

public record BoardInfo(long id, String title, String content, String name) {

    @Builder
    public BoardInfo(long id, String title, String content, String name) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.name = name;
    }

    public static BoardInfo from (BoardEntity entity){
        return BoardInfo.builder()
            .id(entity.getId())
            .content(entity.getContent())
            .title(entity.getTitle())
            .name(entity.getName())
            .build();
    }

}
