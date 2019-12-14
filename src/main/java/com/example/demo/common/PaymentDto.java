package com.example.demo.common;

import com.example.demo.common.PaymentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PaymentDto {
    protected PaymentType type;
}
