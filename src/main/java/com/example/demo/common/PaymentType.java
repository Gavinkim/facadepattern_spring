package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  PaymentType {

    CARD("card"),
    COUPON("coupon");

    private String name;

}
