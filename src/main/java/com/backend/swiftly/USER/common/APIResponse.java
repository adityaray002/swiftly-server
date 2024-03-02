package com.backend.swiftly.USER.common;

public class APIResponse {
    private int status;
    private Object data;

    public Integer getStatus() {
        return status;
    }

    public APIResponse(int status, Object data, Object error) {
        this.status = status;
        this.data = data;
        this.error = error;
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

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    private Object error;
}
