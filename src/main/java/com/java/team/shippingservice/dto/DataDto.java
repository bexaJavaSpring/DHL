package com.java.team.shippingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataDto<T> implements Serializable {
    protected T data;
    protected boolean success;
    private Long totalCount;

    public DataDto(boolean success) {
        this.success = success;
    }

    public DataDto(T data, boolean success) {
        this.data = data;
        this.success = success;
    }
}
