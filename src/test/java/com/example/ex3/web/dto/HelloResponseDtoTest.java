package com.example.ex3.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HelloResponseDtoTest {

    @Test
    @DisplayName("HelloResponseDto 테스트")
    public void test() {
        String name = "test";
        int amount = 1000;
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        Assertions.assertThat(dto.getName()).isEqualTo(name);
        Assertions.assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
