package com.event.demo.repositories;

import com.event.demo.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CouponRespository extends JpaRepository<Coupon, UUID> {
}
