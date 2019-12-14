package com.example.demo.domain.coupon;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon,Long> {
    <T> List<T> findByName(String name, Class<T> type);
}
