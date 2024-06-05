package com.bebe.spring.v2domain;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "review_detail")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewDetailV2 {
    @Id
    private String reviewNo;

    private Long reviewLike;

    private String id;

//    @OneToOne(fetch = FetchType.LAZY)
//    private ReviewV2 review;

}
