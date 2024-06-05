package com.bebe.spring.v2domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrdersV2 is a Querydsl query type for OrdersV2
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrdersV2 extends EntityPathBase<OrdersV2> {

    private static final long serialVersionUID = 198481961L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrdersV2 ordersV2 = new QOrdersV2("ordersV2");

    public final QDeliveryV2 delivery;

    public final QMemberV2 member;

    public final ListPath<OrderDetailV2, QOrderDetailV2> orderDetailList = this.<OrderDetailV2, QOrderDetailV2>createList("orderDetailList", OrderDetailV2.class, QOrderDetailV2.class, PathInits.DIRECT2);

    public final NumberPath<Long> ordersNo = createNumber("ordersNo", Long.class);

    public final EnumPath<OrderStatus> orderStatus = createEnum("orderStatus", OrderStatus.class);

    public final NumberPath<Long> totalPrice = createNumber("totalPrice", Long.class);

    public QOrdersV2(String variable) {
        this(OrdersV2.class, forVariable(variable), INITS);
    }

    public QOrdersV2(Path<? extends OrdersV2> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrdersV2(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrdersV2(PathMetadata metadata, PathInits inits) {
        this(OrdersV2.class, metadata, inits);
    }

    public QOrdersV2(Class<? extends OrdersV2> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.delivery = inits.isInitialized("delivery") ? new QDeliveryV2(forProperty("delivery"), inits.get("delivery")) : null;
        this.member = inits.isInitialized("member") ? new QMemberV2(forProperty("member")) : null;
    }

}

