package com.devopsbuddy.devopsbuddy.repository;

import com.devopsbuddy.devopsbuddy.web.controller.domain.frontend.PasswordResetToken;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetToken,Long> {

PasswordResetToken findByToken(String token);
@Query("select ptr from PasswordResetToken ptr inner join ptr.user u where ptr.user.user_id= ?1")
Set<PasswordResetToken> findAllByUser_id(long userid);

}
