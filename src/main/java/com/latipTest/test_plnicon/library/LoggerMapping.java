package com.latipTest.test_plnicon.library;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class LoggerMapping {

    private Object message;

    private Integer code;

    private String access;

    private String uri;

    private Map<String,String> payloadMapping;

    public void setData(Response<?> response,HttpServletRequest httpServletRequest) {
        this.message = response.getMessage();
        this.code = response.getCode();
        this.access = httpServletRequest.getRemoteAddr() + ":" + httpServletRequest.getRemotePort();
        this.uri = httpServletRequest.getRequestURI();
    }
}
