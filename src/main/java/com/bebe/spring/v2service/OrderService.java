package com.bebe.spring.v2service;

import com.bebe.spring.v2Dto.orderDto.OrderRequestDto;
import com.bebe.spring.v2Dto.productDto.ProductRequestDto;
import com.bebe.spring.v2Dto.productDto.ProductResponseDto;
import com.bebe.spring.v2domain.*;
import com.bebe.spring.v2exception.CreateException;
import com.bebe.spring.v2exception.OrderException;
import com.bebe.spring.v2exception.member.MemberException;
import com.bebe.spring.v2repository.member.MemberRepository;
import com.bebe.spring.v2repository.order.OrderRepository;
import com.bebe.spring.v2repository.product.ProductRepository;
import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void order(OrderRequestDto orderRequestDto) {
        MemberV2 member = findMember(orderRequestDto);

        DeliveryV2 delivery = new DeliveryV2(orderRequestDto.getDelivery());

        Long totalPrice = 0L;
        OrdersV2 order = OrdersV2.createOrder(member, totalPrice);
        List<OrderDetailV2> orderDetailV2List = new ArrayList<>();

        for (OrderDetailV2 detail : orderRequestDto.getOrderDetail()) {
            ProductResponseDto product = getProductResponseDto(detail);
            if (ObjectUtils.isEmpty(product)) {
                throw new OrderException("존재하지 않는 상품입니다.");
            }
            if (product.getProductCnt() < detail.getOrderQty()) {
                throw new OrderException(product.getProductName() + "의 재고가 주문수량보다 적습니다.");
            }
            OrderDetailV2 orderDetailV2 = new OrderDetailV2();
            Long price = OrderDetailV2.orderPrice(product.getProductPrice(), detail.getOrderQty());
            orderDetailV2.setProductNo(detail.getProductNo());
            orderDetailV2.setOrderPrice(price);
            orderDetailV2.setOrderQty(detail.getOrderQty());
            orderDetailV2List.add(orderDetailV2);

            order.addDetail(orderDetailV2);
            totalPrice += price;
        }


        order.addDelivery(delivery);
        orderRepository.createOrder(order);
        orderRepository.createDeliveryAndOrderDetail(delivery, orderDetailV2List);

        for (OrderDetailV2 detail : orderRequestDto.getOrderDetail()) {
            ProductResponseDto product = getProductResponseDto(detail);
            ProductV2 productV2 = new ProductV2(product,detail.getOrderQty(),"order");
            productRepository.addProduct(productV2);

        }

    }

    private ProductResponseDto getProductResponseDto(OrderDetailV2 detail) {
        ProductRequestDto productRequestDto = new ProductRequestDto();
        productRequestDto.setProductNo(detail.getProductNo());
        ProductResponseDto product = productRepository.findProductDetail(productRequestDto);
        return product;
    }

    @Transactional
    public void cancel(OrderRequestDto orderRequestDto){
        MemberV2 member = findMember(orderRequestDto);

        OrdersV2 order = orderRepository.findOrderByOrderNo(orderRequestDto.getOrderNo());
        if(ObjectUtils.isEmpty(order)){
            throw new OrderException("주문 내역이 존재하지 않습니다.");
        }
        if(order.getOrderStatus().equals(OrderStatus.CANCEL)){
            throw new OrderException("이미 취소된 주문 내역입니다.");
        }
        order.setOrderStatus(OrderStatus.CANCEL);
        orderRepository.cancelOrder(order);
    }

    private MemberV2 findMember(OrderRequestDto orderRequestDto) {

        MemberV2 member = memberRepository.findMemberById(orderRequestDto.getId());
        if(ObjectUtils.isEmpty(member)){
            throw new MemberException("주문 회원의 아이디가 잘 못 되었습니다.");
        }
        return member;
    }


    public  List<OrdersV2> findOrderList(OrderRequestDto orderRequestDto) {

        List<OrdersV2> ordersList = orderRepository.findOrderList(orderRequestDto.getId());

        return ordersList;
    }
}
