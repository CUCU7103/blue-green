package org.security.deploytest.controller.dto;

import lombok.Builder;
import org.security.deploytest.service.BoardInfo;

public record SingleResponse(String message, BoardInfo info) {

    @Builder
    public SingleResponse(String message, BoardInfo info) {
        this.message = message;
        this.info = info;
    }

    public static SingleResponse of(String message, BoardInfo info){
        return SingleResponse.builder()
            .message(message)
            .info(info)
            .build();
    }
}
