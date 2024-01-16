package com.senac.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senac.senac.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u JOIN FETCH u.userType WHERE u.login LIKE ?1 and u.password = ?2")
    public User findByLoginAndPassword(String userName, String password);

}
