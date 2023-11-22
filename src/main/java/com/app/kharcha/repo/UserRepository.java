package com.app.kharcha.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.kharcha.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
