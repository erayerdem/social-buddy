package com.buddy.socialbuddy.base.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public record ApiResponse<T>(OperationResult meta, T data) {

    public ApiResponse {
        if (meta == null) {
            meta = new OperationResult("0", "success");
        }
    }

    public  record OperationResult(String returnCode, String returnMessage) {

        public OperationResult {
            if (returnCode == null && returnMessage == null) {
                returnCode = "0";
                returnMessage = "success";
            }
        }
    }

    public  record FieldErrorData(String field, String message) {}
}
