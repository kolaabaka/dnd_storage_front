package com.banturov.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.banturov.models.MyHeroes;

public interface IMyHeroesRepository extends JpaRepository<MyHeroes, Long> {

	@Query(value = "SELECT * FROM heroes WHERE author = :id", nativeQuery = true)
	List<MyHeroes> findAllByAuthor (@Param("id")Long userId);
	
}
