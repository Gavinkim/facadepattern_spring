package com.example.demo.domain.coupon;

import com.example.demo.common.PaymentDto;
import com.example.demo.common.PaymentType;
import com.example.demo.common.SearchDto;
import com.example.demo.domain.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CouponService implements PaymentService {

    private final CouponRepository couponRepository;

    @Override
    public PaymentType getServiceType() {
        return PaymentType.COUPON;
    }

    @Override
    public List<? extends PaymentDto> getList(SearchDto searchDto) {
        List<CouponProjections> projections =  couponRepository.findByName(searchDto.getSearchName(), CouponProjections.class);
        return projections.stream()
                .map(p -> CouponDto.builder()
                        .projections(p)
                        .build()).collect(Collectors.toList());
    }
}
