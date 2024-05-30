package com.banturov.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banturov.models.myUser;

public interface userRepository extends JpaRepository<myUser, Long>{

	Optional<myUser> findByName(String name);
}
