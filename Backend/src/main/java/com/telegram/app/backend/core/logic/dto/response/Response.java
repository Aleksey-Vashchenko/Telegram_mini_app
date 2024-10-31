package com.telegram.app.backend.core.logic.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Getter
public class Response {
    private Integer code = HttpStatus.OK.value();

    public Response(HttpStatus status) {
        this.code = status.value();
    }
}
