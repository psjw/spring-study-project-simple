package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {

    //Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        // String sql = insert into user (%s, %s, %d) value(account, email, age);
        User user = new User();
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-0000-0002");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser03");
        User newUser = userRepository.save(user);
        System.out.println("newUser : "+newUser);
    }

    @Test
    @Transactional
    //org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: com.example.study.model.entity.User.orderDetailList, could not initialize proxy - no Session -> @Transactional 추가
    //orderDetailList 가져오려니깐 Transaction 세션이 없다
    public void read(){
        //select * from user where id = ?
//        Optional<User> user = userRepository.findById(5L);
//        Optional<User> user = userRepository.findByAccount("TestUser03");
        Optional<User> user = userRepository.findByAccountAndEmail("TestUser03","TestUser03@gmail.com");
        user.ifPresent(selectUser -> {
            System.out.println("user : "+selectUser);
            System.out.println("email : "+selectUser.getEmail());
            selectUser.getOrderDetailList().stream().forEach(orderDetail -> {
                System.out.println(orderDetail.getItem());
            });
        });
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(1L);
        user.ifPresent(selectUser->{
            //만약 아이디를 다른 것으로 세팅하면 다른게 업데이트 됨
//            selectUser.setId(3L);
            selectUser.setAccount("PPPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            //ID가 있으면 setting한 값과 기존값 모두 업데이트
            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional //rollback 시켜줌
    public void delete(){
        Optional<User> user = userRepository.findById(1L);

        Assertions.assertTrue(user.isPresent());

        user.ifPresent(selectUser ->{
            userRepository.delete(selectUser);
        });
        Optional<User> deleteUser = userRepository.findById(1L);

        Assertions.assertFalse(deleteUser.isPresent());

        /*if(deleteUser.isPresent()){
            System.out.println("데이터 존재"+deleteUser.get());
        }else{
            System.out.println("데이터 삭제 데이터 없음");
        }*/
    }
}
