package com.banturov.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banturov.models.MyUser;

public interface UserRepository extends JpaRepository<MyUser, Long>{

	Optional<MyUser> findByName(String name);
}
