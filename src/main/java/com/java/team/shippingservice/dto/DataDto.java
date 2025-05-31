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
    protected boolean success;

    public DataDto(boolean success) {
        this.success = success;
    }

    public DataDto(T data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public DataDto(T data) {
        this.data = data;
        this.success = true;
    }
}
