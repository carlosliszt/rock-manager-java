package br.com.carlos.rockmanager.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    private boolean success = true;
    private String message;
    private T data;
    private ResponseError error;

    @JsonIgnore
    private int httpCode = 200;

    @Data
    @AllArgsConstructor
    public static class ResponseError {
        private String code;
        private String message;
    }

}

