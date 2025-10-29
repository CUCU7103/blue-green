package org.security.deploytest.controller.dto;

import java.util.List;
import lombok.Builder;
import org.security.deploytest.service.BoardInfo;

public record ListResponse(String message, List<BoardInfo> info) {

    @Builder
    public ListResponse(String message, List<BoardInfo> info) {
        this.message = message;
        this.info = info;
    }

    public static ListResponse of(String message, List<BoardInfo> info){
        return ListResponse.builder()
            .message(message)
            .info(info)
            .build();
    }
}
