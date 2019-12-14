package com.example.demo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class DemoResponse<T> {
    @JsonProperty("request_time")
    private LocalDateTime requestTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cause;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private DemoPage pagenation;

    public DemoResponse() {
    }

    public static <T> DemoResponse<T> ok(String code, String message){
        return (DemoResponse<T>) DemoResponse.builder()
                .requestTime(LocalDateTime.now())
                .code(code)
                .message(message)
                .build();
    }

    public static <T> DemoResponse<T> ok(T data, String code, String message){
        return (DemoResponse<T>) DemoResponse.builder()
                .requestTime(LocalDateTime.now())
                .code(code)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> DemoResponse<T> ok(T data, String code, String message, DemoPage page){
        return (DemoResponse<T>) DemoResponse.builder()
                .requestTime(LocalDateTime.now())
                .code(code)
                .message(message)
                .data(data)
                .pagenation(page)
                .build();
    }

    public static <T> DemoResponse<T> error(String code, String message, String cause){
        return (DemoResponse<T>) DemoResponse.builder()
                .requestTime(LocalDateTime.now())
                .code(code)
                .message(message)
                .cause(cause)
                .build();
    }
}
