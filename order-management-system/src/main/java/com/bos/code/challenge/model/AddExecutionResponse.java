package com.bos.code.challenge.model;

/**
 * Created by Anupam on 7/7/19.
 */
public class AddExecutionResponse {

    private String description;

    private String code;

    public AddExecutionResponse(String description, String code) {
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "AddExecutionResponse{" +
                "description='" + description + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
