package com.person.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.dao.HumanDao;
import com.person.entity.Human;
import com.person.userdefinedexception.IdNotFoundException;
import com.person.userdefinedexception.NameNotFoundException;
import com.person.userdefinedexception.NoOneFoundException;

@Service
public class HumanService {

	@Autowired
	HumanDao humanDao;
	public String setOne(Human human) {
		// TODO Auto-generated method stub
		return humanDao.setOne(human);
	}
	public String setMany(List<Human> human) {
		// TODO Auto-generated method stub
		List<Human> l3 = human.stream().filter(x->x.getName()!="").collect(Collectors.toList());
		return humanDao.setMany(l3);
	}
	public Human getById(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return humanDao.getById(id);	
	}
	public List<Human> getAll() {
		// TODO Auto-generated method stub
		return humanDao.getAll();
	}
	
	public String updateHuman(int id) {
		// TODO Auto-generated method stub
		List<Human> l1 = getAll();
		l1.stream().filter(x->x.getId()==id).forEach(y->y.setAge(y.getAge()+2));
		return humanDao.setMany(l1);
	}
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		return humanDao.deleteById(id);
	}
	public String deleteAll() {
		// TODO Auto-generated method stub
		return humanDao.deleteAll();
	}
	public List<Human> getByName(String name) throws NameNotFoundException{
		// TODO Auto-generated method stub
		List<Human> l1= humanDao.getByName(name);
		if(l1.isEmpty()) {
			throw new NameNotFoundException("Name not Found.");
		}else {
			return l1;
		}		
	}
	public List<Human> getByAgeRange(int age, int age1) throws NoOneFoundException {
		// TODO Auto-generated method stub
		List<Human> l1=humanDao.getByAgeRange(age,age1);
		if(l1.isEmpty()) {
			throw new NoOneFoundException("No one Found.");
		} else {
			return l1;
		}
	}
}
