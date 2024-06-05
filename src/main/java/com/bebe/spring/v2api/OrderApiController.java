package com.bebe.spring.v2api;

import com.bebe.spring.v2Dto.orderDto.OrderRequestDto;
import com.bebe.spring.v2domain.OrdersV2;
import com.bebe.spring.v2service.OrderService;
import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
@Slf4j
public class OrderApiController {
    private final OrderService orderService;

    @PostMapping("/saveOrder")
    public void saveOrder(@RequestBody OrderRequestDto orderRequestDto){
        orderService.order(orderRequestDto);
    }
    @PostMapping("/findOrderList")
    public ResponseEntity<List<OrdersV2>> findOrderList(@RequestBody String id){
        OrderRequestDto orderRequestDto =new OrderRequestDto();
        orderRequestDto.setId(id);
        List<OrdersV2> a  = orderService.findOrderList(orderRequestDto);
        return ResponseEntity.ok().body(a);
    }

}
