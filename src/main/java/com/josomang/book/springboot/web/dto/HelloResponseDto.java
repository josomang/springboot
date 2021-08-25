package com.josomang.book.springboot.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;

}
