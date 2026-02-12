package com.zs.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zs.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	@Query("SELECT u FROM User u WHERE u.userid=:userid AND u.passwd=:passwd")
	Optional<User> findByLogin(String userid, String passwd);
}
