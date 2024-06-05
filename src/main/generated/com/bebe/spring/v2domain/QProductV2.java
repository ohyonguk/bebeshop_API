package com.bebe.spring.v2domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductV2 is a Querydsl query type for ProductV2
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductV2 extends EntityPathBase<ProductV2> {

    private static final long serialVersionUID = 1196819683L;

    public static final QProductV2 productV2 = new QProductV2("productV2");

    public final StringPath categoryNo = createString("categoryNo");

    public final NumberPath<Integer> productCnt = createNumber("productCnt", Integer.class);

    public final StringPath productImg1 = createString("productImg1");

    public final StringPath productImg2 = createString("productImg2");

    public final StringPath productImg3 = createString("productImg3");

    public final StringPath productName = createString("productName");

    public final NumberPath<Long> productNo = createNumber("productNo", Long.class);

    public final NumberPath<Long> productPrice = createNumber("productPrice", Long.class);

    public final ListPath<ReviewV2, QReviewV2> reviewList = this.<ReviewV2, QReviewV2>createList("reviewList", ReviewV2.class, QReviewV2.class, PathInits.DIRECT2);

    public QProductV2(String variable) {
        super(ProductV2.class, forVariable(variable));
    }

    public QProductV2(Path<? extends ProductV2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductV2(PathMetadata metadata) {
        super(ProductV2.class, metadata);
    }

}

