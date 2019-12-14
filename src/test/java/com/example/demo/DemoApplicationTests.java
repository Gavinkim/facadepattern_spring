package com.example.demo;

import com.example.demo.common.PaymentCommonService;
import com.example.demo.common.PaymentDto;
import com.example.demo.common.PaymentType;
import com.example.demo.common.SearchDto;
import com.example.demo.domain.card.Card;
import com.example.demo.domain.card.CardRepository;
import com.example.demo.domain.coupon.Coupon;
import com.example.demo.domain.coupon.CouponRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private PaymentCommonService paymentCommonService;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CouponRepository couponRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
        List<Coupon> coupons = Arrays.asList(
                Coupon.builder()
                        .name("test")
                        .couponCode("test-10")
                        .build(),
                Coupon.builder()
                        .name("test")
                        .couponCode("test-11")
                        .build(),
                Coupon.builder()
                        .name("test")
                        .couponCode("test-12")
                        .build(),
                Coupon.builder()
                        .name("test")
                        .couponCode("test-13")
                        .build()
        );
        List<Card> cards = Arrays.asList(
                Card.builder()
                        .name("test")
                        .cardNumber("1234456")
                        .build(),
                Card.builder()
                        .name("test")
                        .cardNumber("1234457")
                        .build(),
                Card.builder()
                        .name("test")
                        .cardNumber("1234458")
                        .build()
        );

        cardRepository.saveAll(cards);
        couponRepository.saveAll(coupons);

        List<? extends PaymentDto> couponDtos = paymentCommonService.getPaymentList(SearchDto.builder()
                .searchName("test")
                .type(PaymentType.COUPON)
                .build());
        assertEquals(4, couponDtos.size());

        List<? extends PaymentDto> cardDtos = paymentCommonService.getPaymentList(SearchDto.builder()
                .searchName("test")
                .type(PaymentType.CARD)
                .build());

        assertEquals(3,cardDtos.size());
    }
}
