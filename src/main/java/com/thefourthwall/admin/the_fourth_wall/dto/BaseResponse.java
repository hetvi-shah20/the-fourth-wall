package com.thefourthwall.admin.the_fourth_wall.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BaseResponse<T>(String resultMessage, T data) {

    public BaseResponse(String resultMessage) {
        this( resultMessage, null);
    }

    public BaseResponse( String resultMessage, T data) {
        this.resultMessage = resultMessage;
        this.data = data;
    }
}
