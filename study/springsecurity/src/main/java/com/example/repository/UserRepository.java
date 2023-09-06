package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//
//CRUD 함수를 jpaRepository가 가지고 있음
//@Repository 어노테이션 없이 IOC가 된다 이유는 jpa repository를 상속했기 때문
public interface UserRepository extends JpaRepository<User,Integer> {
    //findBy규칙 ->
    public User findByUsername(String username);

}
