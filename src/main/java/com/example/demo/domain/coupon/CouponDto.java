package com.example.demo.domain.coupon;

import com.example.demo.common.PaymentType;
import com.example.demo.common.PaymentDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CouponDto extends PaymentDto {
    private String name;
    private String couponCode;

    @Builder
    public CouponDto(CouponProjections projections){
        this.name = projections.getName();
        this.couponCode = projections.getCouponCode();
        this.type = PaymentType.COUPON;
    }
}
