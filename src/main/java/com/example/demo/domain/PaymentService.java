package com.example.demo.domain;

import com.example.demo.common.PaymentDto;
import com.example.demo.common.PaymentType;
import com.example.demo.common.SearchDto;

import java.util.List;

public interface PaymentService {
    PaymentType getServiceType();
    List<? extends PaymentDto> getList(SearchDto searchDto);
}
