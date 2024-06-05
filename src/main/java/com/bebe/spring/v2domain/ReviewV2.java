package com.bebe.spring.v2domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "review")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewV2 extends Common{
    @Id
    private String reviewNo;

    //private String productNo;

    private String id;

    private String reviewScore;

    private String reviewContent;

    private Long reviewLike;
//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY)
//    private MemberV2 member;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productNo")
    private ProductV2 product;

}
