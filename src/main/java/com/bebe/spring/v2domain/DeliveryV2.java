package com.bebe.spring.v2domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "delivery")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryV2 extends Common{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deliveryNo;

    private String zipCode;

    private String addr;

    private String addrDetail;

    private String receiver;

    private String addrReq;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_no")
    private OrdersV2 orders;


    public DeliveryV2(DeliveryV2 delivery) {
        this.zipCode = delivery.getZipCode();
        this.addr = delivery.getAddr();
        this.addrDetail = delivery.getAddrDetail();
        this.receiver = delivery.getReceiver();
        this.addrReq = delivery.getAddrReq();
        this.deliveryStatus = DeliveryStatus.SHIPPING;
    }

}
