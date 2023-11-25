package com.app.kharcha.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.kharcha.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(nativeQuery = true, value = "select * from user where user= :userEmail")
	public User findUserByEmail( @Param("userEmail") String user);
}
