package com.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.entity.Human;
import com.person.service.HumanService;
import com.person.userdefinedexception.IdNotFoundException;
import com.person.userdefinedexception.NameNotFoundException;
import com.person.userdefinedexception.NoOneFoundException;

@RestController
@RequestMapping("/human")
public class HumanController {
	@Autowired
	HumanService humanService;
	
	@PostMapping("/setOne")
	public String setOne(@RequestBody Human human) {
		return humanService.setOne(human);
	}
	@PostMapping("/setMany")
	public String setMany(@RequestBody List<Human> human) {
		return humanService.setMany(human);
	}
	@GetMapping("/getById/{id}")
	public Human getByid(@PathVariable int id) throws IdNotFoundException {
		return humanService.getById(id);
	}
	
	@GetMapping("/getByName/{name}")
	public List<Human> getByName(@PathVariable String name) throws NameNotFoundException {
		return humanService.getByName(name);
	}
	
	@GetMapping("/getAll")
	public List<Human> getAll(){
		return humanService.getAll();
	}
	@PutMapping("/updateHuman/{id}")
	public String updateHuman(@PathVariable int id){
		return humanService.updateHuman(id);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id) {
		return humanService.deleteById(id);
	}
	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		return humanService.deleteAll();
	}
	
	@GetMapping("getByAgeRange/{age1}/{age2}")
	public List<Human> getByAgeRange(@PathVariable ("age1") int age,@PathVariable ("age2") int age1) throws NoOneFoundException
	{
		return humanService.getByAgeRange(age,age1);
	}
}
