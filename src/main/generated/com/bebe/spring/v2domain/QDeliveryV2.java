package com.bebe.spring.v2domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDeliveryV2 is a Querydsl query type for DeliveryV2
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDeliveryV2 extends EntityPathBase<DeliveryV2> {

    private static final long serialVersionUID = 2066476920L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDeliveryV2 deliveryV2 = new QDeliveryV2("deliveryV2");

    public final StringPath addr = createString("addr");

    public final StringPath addrDetail = createString("addrDetail");

    public final StringPath addrReq = createString("addrReq");

    public final NumberPath<Long> deliveryNo = createNumber("deliveryNo", Long.class);

    public final EnumPath<DeliveryStatus> deliveryStatus = createEnum("deliveryStatus", DeliveryStatus.class);

    public final QOrdersV2 orders;

    public final StringPath receiver = createString("receiver");

    public final StringPath zipCode = createString("zipCode");

    public QDeliveryV2(String variable) {
        this(DeliveryV2.class, forVariable(variable), INITS);
    }

    public QDeliveryV2(Path<? extends DeliveryV2> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDeliveryV2(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDeliveryV2(PathMetadata metadata, PathInits inits) {
        this(DeliveryV2.class, metadata, inits);
    }

    public QDeliveryV2(Class<? extends DeliveryV2> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.orders = inits.isInitialized("orders") ? new QOrdersV2(forProperty("orders"), inits.get("orders")) : null;
    }

}

