package com.bebe.spring.v2domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCategoryV2 is a Querydsl query type for CategoryV2
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCategoryV2 extends EntityPathBase<CategoryV2> {

    private static final long serialVersionUID = -2009762302L;

    public static final QCategoryV2 categoryV2 = new QCategoryV2("categoryV2");

    public final StringPath categoryName = createString("categoryName");

    public final StringPath categoryNo = createString("categoryNo");

    public final NumberPath<Integer> depth = createNumber("depth", Integer.class);

    public QCategoryV2(String variable) {
        super(CategoryV2.class, forVariable(variable));
    }

    public QCategoryV2(Path<? extends CategoryV2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategoryV2(PathMetadata metadata) {
        super(CategoryV2.class, metadata);
    }

}

