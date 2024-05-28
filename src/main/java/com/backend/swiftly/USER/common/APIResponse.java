package com.backend.swiftly.USER.common;

public class APIResponse {
    private int status;
    private Object data;

    public Object getStatus() {
        return status;
    }

    public APIResponse(int status, Object data, Boolean isError) {
        this.status = status;
        this.data = data;
        this.isError = isError;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getIsError() {
        return isError;
    }

    public void setIsError(Boolean isError) {
        this.isError = isError;
    }

    private Boolean isError;
}
