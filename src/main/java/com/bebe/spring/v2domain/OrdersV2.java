package com.bebe.spring.v2domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.ast.Or;
import org.hibernate.query.Order;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrdersV2 extends Common{
    @Id
    @Column(name="order_no")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ordersNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private MemberV2 member;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private Long totalPrice;

    @OneToMany(mappedBy = "orders")
    private List<OrderDetailV2> orderDetailList = new ArrayList<>();

    @OneToOne(mappedBy = "orders",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private DeliveryV2 delivery;

    public void addDetail(OrderDetailV2 orderDetailV2){
        this.orderDetailList.add(orderDetailV2);
        orderDetailV2.setOrders(this);
    }
    public void addDelivery(DeliveryV2 deliveryV2){
        this.setDelivery(deliveryV2);
        deliveryV2.setOrders(this);
    }
    public static OrdersV2 createOrder(MemberV2 member,DeliveryV2 delivery,Long price, List<OrderDetailV2> orderDetail){
        OrdersV2 ordersV2 = new OrdersV2();
        ordersV2.setMember(member);
        ordersV2.setTotalPrice(price);
        ordersV2.setOrderStatus(OrderStatus.ORDER);
        return ordersV2;
    }
    public static OrdersV2 createOrder(MemberV2 member,Long price){
        OrdersV2 ordersV2 = new OrdersV2();
        ordersV2.setMember(member);
        ordersV2.setTotalPrice(price);
        ordersV2.setOrderStatus(OrderStatus.ORDER);
        return ordersV2;
    }


}
