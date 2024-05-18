package com.example.springbootcrudrestapi.repository;

import com.example.springbootcrudrestapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //this annotation is optional since simpleJPARepository  class has already the repository annotation which implements jparepository and in terms it also implements user repository
public interface UserRepository extends JpaRepository<User, Long> { //first param entity and second param is type of id/primary key
}
