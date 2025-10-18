package com.latipTest.test_plnicon.library;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;

@Getter
@Setter
public class Response<D> {
    private Integer code = 0;
    private Object message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private D data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object validation;

    public void setResponseCode(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }
    public void setValidation(Errors errors) {
        this.setResponseCode(ResponseCode.VALIDATION);
        this.validation = Constants.validateErrorMessage(errors);
    }

    public void setValidation(Object validation) {
        this.validation = validation;
    }

    public Response() {
    }
    public Response(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }


}