package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private String content;

    // 1: N
    // Lazy = 지연로딩, Eager = 즉시로딩

    // Lazy = select * from items where  id=?

    // Eager = 1 : 1
    // LeftOuterJoin
    //item_id = order_detail.item_id
    //user_id = order_detail.user_id
    // where item.id=?
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
    List<OrderDetail> orderDetailList;

}
