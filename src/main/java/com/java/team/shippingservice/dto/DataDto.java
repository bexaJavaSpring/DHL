package com.java.team.shippingservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class DataDto<T> implements Serializable {
    protected T data;
    protected String message;
    protected boolean success;

    public DataDto(boolean success) {
        this.success = success;
    }

    public DataDto(T data, String message, boolean success) {
        this.data = data;
        this.message = message;
        this.success = success;
    }

    public DataDto(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public DataDto(T data) {
        this.data = data;
        this.success = true;
    }

    public DataDto(T data, String message) {
        this.data = data;
        this.message = message;
        this.success = true;
    }

}
