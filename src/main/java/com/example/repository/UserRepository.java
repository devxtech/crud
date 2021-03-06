package com.example.repository;


import com.example.domain.User;
import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<User, Long>{
    User findByLogin(String login);
    User findOne(Long id);
}
