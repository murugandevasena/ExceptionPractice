package com.cricket.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cricket.entity.Cricket;
import com.cricket.repository.CricketRepository;
import com.cricket.userdefinedexception.IdNotFoundException;
@Repository
public class CricketDao {
@Autowired
CricketRepository cricketRepository;

	public String setOne(Cricket cricket) {
		// TODO Auto-generated method stub
		cricketRepository.save(cricket);
		return "Player Details saved successfully";
	}

	public String setMany(List<Cricket> cricket) {
		// TODO Auto-generated method stub
		cricketRepository.saveAll(cricket);
		return "List of playesrs details saved successfully";
	}

	public List<Cricket> getAll() {
		// TODO Auto-generated method stub
		return cricketRepository.findAll();
		
	}

	public List<Cricket> getByAgeRange(int age1, int age2) {
		// TODO Auto-generated method stub
		return cricketRepository.getByAgeRange(age1,age2);
	}

	public List<Cricket> getByCountry(String country) {
		// TODO Auto-generated method stub
		return cricketRepository.getByCountry(country);
	}

	public List<String> getNameByRuns(int run) {
		// TODO Auto-generated method stub
		return cricketRepository.getNameByRuns(run);
	}

	public List<Cricket> getByJercyNumber(int jercy) {
		// TODO Auto-generated method stub
		return cricketRepository.getByJercyNumber(jercy);
	}

	public Cricket getById(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		//return cricketRepository.findById(id).get(); 
		return cricketRepository.findById(id).orElseThrow(()->new IdNotFoundException("Id not found.Check"));
	}

}
