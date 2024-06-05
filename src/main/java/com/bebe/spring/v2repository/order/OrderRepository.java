package com.bebe.spring.v2repository.order;

import com.bebe.spring.v2domain.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.hibernate.query.Order;
import org.hibernate.sql.ast.tree.Statement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    private final EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;

    /**
     * Instantiates a new Member repository.
     *
     * @param entityManager the entity manager
     */
    public OrderRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    public void createOrder(OrdersV2 order) {
        entityManager.persist(order);
    }
    public void cancelOrder(OrdersV2 order){
        entityManager.merge(order);
    }

    public OrdersV2 findOrderByOrderNo(String ordersNo){
        return jpaQueryFactory.selectFrom(QOrdersV2.ordersV2)
//                .where(QOrdersV2.ordersV2.orderNo.eq(ordersNo))
                .fetchOne();
}

public void createDeliveryAndOrderDetail(DeliveryV2 delivery, List<OrderDetailV2> orderDetailV2List) {
        entityManager.persist(delivery);
        for(OrderDetailV2 orderDetailV2 : orderDetailV2List){
            entityManager.persist(orderDetailV2);
        }
    }

    public List<OrdersV2> findOrderList(String id) {
        return jpaQueryFactory.select(QOrdersV2.ordersV2)
                .from(QOrdersV2.ordersV2)
                .innerJoin(QOrdersV2.ordersV2)
                .on(QOrdersV2.ordersV2.ordersNo.eq(QDeliveryV2.deliveryV2.orders.ordersNo)).fetchJoin()
                .innerJoin(QOrdersV2.ordersV2)
                .on(QOrderDetailV2.orderDetailV2.orders.ordersNo.eq(QOrdersV2.ordersV2.ordersNo)).fetchJoin()
                .where(QOrdersV2.ordersV2.member.id.eq(id)).fetch();
    }
}
