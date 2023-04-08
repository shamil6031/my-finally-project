package com.example.myfinallyproject.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CommonresponseDTO<T> implements Serializable {

    private static final long serialVersionUID = 1;

     private Status status;

     private T data;
}
