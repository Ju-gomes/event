package com.event.demo.models.coupon;

import com.event.demo.models.event.Event;
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
