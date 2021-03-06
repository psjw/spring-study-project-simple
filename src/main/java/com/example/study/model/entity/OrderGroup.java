package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = {"user"})
public class OrderGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String orderType; // 주문의 형태 일괄 / 개별 발송

    private String revAddress;
    private String revName;
    private String paymentType; //카드 현금 결제

    private BigDecimal totalPrice;

    private Integer totalQuantity;
    private LocalDateTime orderAt;
    private LocalDateTime arrivalDate;


    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // OrderGroup N : 1 User
    @ManyToOne
    private User user;

}
