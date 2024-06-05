package com.bebe.spring.v2repository.member;

import com.bebe.spring.v2Dto.MemberSearchDto;
import com.bebe.spring.v2Dto.QMemberSearchDto;
import com.bebe.spring.v2domain.MemberV2;
import com.bebe.spring.v2domain.QMemberV2;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.bebe.spring.v2domain.QMemberV2.memberV2;

/**
 * The type Member repository.
 */
@Repository
public class MemberRepository  {

    private final EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;

    /**
     * Instantiates a new Member repository.
     *
     * @param entityManager the entity manager
     */
    public MemberRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    /**
     * Save.
     *
     * @param memberV2 the member v 2
     */
    public void save(MemberV2 memberV2){
        entityManager.persist(memberV2);
        entityManager.flush();
    }

    /**
     * 회원 id로 조회.
     *
     * @param id the id
     * @return the member v 2
     */
    public MemberV2 findMemberById(String id){
        return jpaQueryFactory.select(memberV2)
                .from(memberV2)
                .where(memberV2.id.eq(id))
                .fetchOne();
    }

    /**
     * 회원 조건 검색(name, tel).
     *
     * @param memberSearchDto the member search dto
     * @return the list
     */
    public List<MemberSearchDto> findMember(MemberSearchDto memberSearchDto){
        return jpaQueryFactory.select(new QMemberSearchDto(
                        memberV2.id,
                        memberV2.name,
                        memberV2.tel
                ))
                .from(memberV2)
                .where(nameTelEq(memberSearchDto.getName(),memberSearchDto.getTel()))
                .fetch();
    }

    /**
     * 회원삭제
     *
     * @param id the id
     * @return the long
     */
    public long deleteMember(String id){
        return jpaQueryFactory.delete(QMemberV2.memberV2)
                .where(QMemberV2.memberV2.id.eq(id))
                .execute();
    }

    private BooleanBuilder nameTelEq(String name, String tel) {
        return nameEq(name).and(telEq(tel));
    }

    private BooleanBuilder telEq(String tel) {
        return tel != null ? new BooleanBuilder(memberV2.tel.eq(tel)) : new BooleanBuilder();
    }

    private BooleanBuilder nameEq(String name) {
        return name != null ? new BooleanBuilder(memberV2.name.eq(name)) : new BooleanBuilder();

    }
}
