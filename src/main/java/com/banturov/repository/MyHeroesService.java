package com.banturov.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banturov.models.MyHeroes;

@Service
public class MyHeroesService {

	@Autowired
	private IMyHeroesRepository rep;

	public List<MyHeroes> findHero(Long id) {
		List<MyHeroes> resultSet = new ArrayList<>();
		resultSet = (List<MyHeroes>) rep.findAllByAuthor(id);
		return resultSet;
	}
	
	public void save(MyHeroes heroe) {
		rep.save(heroe);
	}
	
	public List<MyHeroes> findAll(){
		return rep.findAll();
	}

}
