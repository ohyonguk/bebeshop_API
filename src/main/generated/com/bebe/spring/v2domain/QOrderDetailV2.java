package com.bebe.spring.v2domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderDetailV2 is a Querydsl query type for OrderDetailV2
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderDetailV2 extends EntityPathBase<OrderDetailV2> {

    private static final long serialVersionUID = 1552904499L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderDetailV2 orderDetailV2 = new QOrderDetailV2("orderDetailV2");

    public final NumberPath<Long> orderDetailId = createNumber("orderDetailId", Long.class);

    public final NumberPath<Long> orderPrice = createNumber("orderPrice", Long.class);

    public final NumberPath<Integer> orderQty = createNumber("orderQty", Integer.class);

    public final QOrdersV2 orders;

    public final NumberPath<Long> productNo = createNumber("productNo", Long.class);

    public QOrderDetailV2(String variable) {
        this(OrderDetailV2.class, forVariable(variable), INITS);
    }

    public QOrderDetailV2(Path<? extends OrderDetailV2> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderDetailV2(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderDetailV2(PathMetadata metadata, PathInits inits) {
        this(OrderDetailV2.class, metadata, inits);
    }

    public QOrderDetailV2(Class<? extends OrderDetailV2> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.orders = inits.isInitialized("orders") ? new QOrdersV2(forProperty("orders"), inits.get("orders")) : null;
    }

}

