package com.bebe.spring.v2domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="order_detail")
public class OrderDetailV2 {
    @Id
    @GeneratedValue
    private Long orderDetailId;

    private Long productNo;

    private Integer orderQty;

    private Long orderPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_no")
    private OrdersV2 orders;

    public static Long orderPrice(Long price, int qty){
        return price * qty;
    }


//    @JsonIgnore
//    @OneToMany(mappedBy = "orderDetail",fetch = FetchType.LAZY)
//    private List<ProductV2> product;
}
