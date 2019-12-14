package com.example.demo.common;

import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class SearchDto {
    private PaymentType type;
    private String searchName;
}
