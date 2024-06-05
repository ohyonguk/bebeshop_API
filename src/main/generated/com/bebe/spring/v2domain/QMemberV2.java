package com.bebe.spring.v2domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberV2 is a Querydsl query type for MemberV2
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberV2 extends EntityPathBase<MemberV2> {

    private static final long serialVersionUID = -1685281122L;

    public static ConstructorExpression<MemberV2> create(Expression<String> id, Expression<String> emailId, Expression<String> emailDomain, Expression<String> tel, Expression<String> name) {
        return Projections.constructor(MemberV2.class, new Class<?>[]{String.class, String.class, String.class, String.class, String.class}, id, emailId, emailDomain, tel, name);
    }

    public static final QMemberV2 memberV2 = new QMemberV2("memberV2");

    public final StringPath emailDomain = createString("emailDomain");

    public final StringPath emailId = createString("emailId");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final ListPath<OrdersV2, QOrdersV2> order = this.<OrdersV2, QOrdersV2>createList("order", OrdersV2.class, QOrdersV2.class, PathInits.DIRECT2);

    public final StringPath password = createString("password");

    public final StringPath tel = createString("tel");

    public QMemberV2(String variable) {
        super(MemberV2.class, forVariable(variable));
    }

    public QMemberV2(Path<? extends MemberV2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberV2(PathMetadata metadata) {
        super(MemberV2.class, metadata);
    }

}

