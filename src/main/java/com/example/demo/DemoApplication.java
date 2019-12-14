package com.example.demo;

import com.example.demo.domain.card.Card;
import com.example.demo.domain.card.CardRepository;
import com.example.demo.domain.coupon.Coupon;
import com.example.demo.domain.coupon.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class DemoApplication {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CouponRepository couponRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    public void initData(){
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
    }

}
