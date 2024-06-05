package com.bebe.spring.v2domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCartV2 is a Querydsl query type for CartV2
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCartV2 extends EntityPathBase<CartV2> {

    private static final long serialVersionUID = -1788778588L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCartV2 cartV2 = new QCartV2("cartV2");

    public final NumberPath<Long> cartNo = createNumber("cartNo", Long.class);

    public final NumberPath<Long> count = createNumber("count", Long.class);

    public final ComparablePath<Character> dispYn = createComparable("dispYn", Character.class);

    public final QMemberV2 member;

    public final QProductV2 product;

    public QCartV2(String variable) {
        this(CartV2.class, forVariable(variable), INITS);
    }

    public QCartV2(Path<? extends CartV2> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCartV2(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCartV2(PathMetadata metadata, PathInits inits) {
        this(CartV2.class, metadata, inits);
    }

    public QCartV2(Class<? extends CartV2> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMemberV2(forProperty("member")) : null;
        this.product = inits.isInitialized("product") ? new QProductV2(forProperty("product")) : null;
    }

}

