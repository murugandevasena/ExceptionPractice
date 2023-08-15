package com.person.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.person.entity.Human;
import com.person.repository.HumanRepository;

@Repository
public class HumanDao {
	@Autowired
	HumanRepository humanRepository;

	public String setOne(Human human) {
		// TODO Auto-generated method stub
		humanRepository.save(human);
		return "Single person details saved successfully";
	}

	public String setMany(List<Human> human) {
		// TODO Auto-generated method stub
		humanRepository.saveAll(human);
		return "List of persons details saved successfully";
	}

	public Human getById(int id) {
		// TODO Auto-generated method stub
		return humanRepository.findById(id).get();
	}

	public List<Human> getAll() {
		// TODO Auto-generated method stub
		return humanRepository.getAll();
	}
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		humanRepository.deleteById(id);
		return "Deleted for the specfic id successfully";
	}

	public String deleteAll() {
		// TODO Auto-generated method stub
		humanRepository.deleteAll();
		return "All details deleted successfully";
	}

	public List<Human> getByName(String name) {
		// TODO Auto-generated method stub
		return humanRepository.getByName(name);
	}

	public List<Human> getByAgeRange(int age, int age1) {
		// TODO Auto-generated method stub
		return humanRepository.getByAgeRange(age,age1);
	}	

}
