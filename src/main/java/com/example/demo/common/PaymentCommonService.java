package com.example.demo.common;

import com.example.demo.domain.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentCommonService {

    private Map<PaymentType, PaymentService> serviceMap =new HashMap<>();

    @Autowired
    public PaymentCommonService(List<PaymentService> paymentServiceList) {
        paymentServiceList.forEach(service->serviceMap.put(service.getServiceType(), service));
    }

    public List<? extends PaymentDto> getPaymentList(SearchDto searchDto) {
        return serviceMap.get(searchDto.getType()).getList(searchDto);
    }
}
