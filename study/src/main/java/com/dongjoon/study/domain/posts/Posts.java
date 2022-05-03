package com.dongjoon.study.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
//@Table(name = "dongjun")
@Table(name = "demo02")
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String keyword;

    @Column(columnDefinition = "TEXT", nullable = false)
    private double weight;

    private int cluster;

    @Builder
    public Posts(String keyword, double weight, int cluster){
        this.keyword = keyword;
        this.weight = weight;
        this.cluster = cluster;
    }
}
