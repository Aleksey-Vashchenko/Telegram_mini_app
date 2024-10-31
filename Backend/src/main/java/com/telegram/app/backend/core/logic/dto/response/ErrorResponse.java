package com.telegram.app.backend.core.logic.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.LinkedList;
import java.util.List;

@Getter
public class ErrorResponse extends Response{
    @JsonProperty
    String error;

    @JsonProperty("extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ExtraErrorMessage> extra = new LinkedList<>();

    public ErrorResponse(HttpStatus status, String error) {
        super(status);
        this.error = error;
    }


    public void addExtra(List<ExtraErrorMessage> extraErrorMessage){
        extra.addAll(extraErrorMessage);
    }

}
