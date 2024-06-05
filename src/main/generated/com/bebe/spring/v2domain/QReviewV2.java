package com.bebe.spring.v2domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewV2 is a Querydsl query type for ReviewV2
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewV2 extends EntityPathBase<ReviewV2> {

    private static final long serialVersionUID = -1297032228L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewV2 reviewV2 = new QReviewV2("reviewV2");

    public final StringPath id = createString("id");

    public final QProductV2 product;

    public final StringPath reviewContent = createString("reviewContent");

    public final NumberPath<Long> reviewLike = createNumber("reviewLike", Long.class);

    public final StringPath reviewNo = createString("reviewNo");

    public final StringPath reviewScore = createString("reviewScore");

    public QReviewV2(String variable) {
        this(ReviewV2.class, forVariable(variable), INITS);
    }

    public QReviewV2(Path<? extends ReviewV2> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewV2(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewV2(PathMetadata metadata, PathInits inits) {
        this(ReviewV2.class, metadata, inits);
    }

    public QReviewV2(Class<? extends ReviewV2> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProductV2(forProperty("product")) : null;
    }

}

