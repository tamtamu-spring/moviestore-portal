package com.devopsbuddy.devopsbuddy.repository;

import com.devopsbuddy.devopsbuddy.web.controller.domain.frontend.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

 User findUserByUserName(String user_name);

}
