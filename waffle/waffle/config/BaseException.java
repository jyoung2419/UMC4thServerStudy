package com.example.waffle.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseException extends Exception {
    private com.example.waffle.config.BaseResponseStatus status;
}
