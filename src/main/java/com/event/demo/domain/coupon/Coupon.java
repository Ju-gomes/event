package com.event.demo.domain.coupon;

import com.event.demo.domain.event.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coupon")
@Entity
public class Coupon {

    @Id
    @GeneratedValue
    private UUID uuid;

    private String code;
    private String discount;
    private Date valid;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;




}
