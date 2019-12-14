package com.example.demo.api;

import com.example.demo.common.DemoResponse;
import com.example.demo.common.PaymentCommonService;
import com.example.demo.common.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentCommonService paymentCommonService;

    @GetMapping("/payments")
    public DemoResponse getList(SearchDto searchDto){
        return DemoResponse.ok(paymentCommonService.getPaymentList(SearchDto.builder()
                .searchName(searchDto.getSearchName())
                .type(searchDto.getType())
                .build()),"20000","SUCCESS");
    }

}
