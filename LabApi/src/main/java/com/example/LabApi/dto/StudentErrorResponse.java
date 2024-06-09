package com.example.LabApi.dto;

public class StudentErrorResponse {
    private int status;
    private String message;
    private long timeStap;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStap() {
        return timeStap;
    }

    public void setTimeStap(long timeStap) {
        this.timeStap = timeStap;
    }
}
