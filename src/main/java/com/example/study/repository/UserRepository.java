package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//T : 제너릭 타입(object) , ID : primary key Type
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //가장 최근것 리턴
    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);

}
