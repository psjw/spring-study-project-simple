package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//T : 제너릭 타입(object) , ID : primary key Type
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //select * from user where account = ? <<test03, test04
    Optional<User> findByAccount(String account); // findBy select ->  Account : 계정으로 찾음

    Optional<User> findByEmail(String email);

    //select * from user where account = ? and email = ?
    Optional<User> findByAccountAndEmail(String email,String account);
}
