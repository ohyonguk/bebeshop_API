package com.bebe.spring.v2Dto.orderDto;

import com.bebe.spring.v2domain.DeliveryV2;
import com.bebe.spring.v2domain.OrderDetailV2;
import com.bebe.spring.v2domain.OrderStatus;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {
   private String orderNo;
   private String id;
   private DeliveryV2 delivery;
   private OrderStatus orderStatus;
   private List<OrderDetailV2> orderDetail;
   private Long totalPrice;
}
