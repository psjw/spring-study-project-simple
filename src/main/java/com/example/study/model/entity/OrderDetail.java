package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity//order_detail
@ToString(exclude = {"user","item"}) //java.lang.StackOverflowError : ToString 상호 참조하기 떄문에 오류남
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderAt;
    //N : 1
    @ManyToOne
    private User user; // 하이버네이트에서 알아서 userId찾아감

    //N : 1
    @ManyToOne
    private Item item;
}
