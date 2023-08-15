package com.cricket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.entity.Cricket;
import com.cricket.service.CricketService;
import com.cricket.userdefinedexception.IdNotFoundException;
import com.cricket.userdefinedexception.JercyNotFoundException;
import com.cricket.userdefinedexception.PlayerNotFoundException;

@RestController
@RequestMapping(value="cric")
public class CricketController {
	@Autowired
	CricketService cricketService;
	
	@PostMapping("/setOne")
	public String setOne(@RequestBody Cricket cricket) throws JercyNotFoundException {
		return cricketService.setOne(cricket);
	}
	
	@PostMapping("/setMany")
	public String setMany(@RequestBody List<Cricket> cricket) throws JercyNotFoundException {
		return cricketService.setMany(cricket);
	}
	@GetMapping("/getAll")
	public List<Cricket> getAll() {
		return cricketService.getAll();
	}
	
	@GetMapping("/getByAgeRange/{age1}/{age2}")
	public List<Cricket> getByAgeRange(@PathVariable("age1") int age1,@PathVariable("age2") int age2){
		return cricketService.getByAgeRange(age1,age2);
	}
	
	@GetMapping("/getByCountry/{c}")
	public List<Cricket> getByCountry(@PathVariable("c") String country){
		return cricketService.getByCountry(country);
	}
	
	@GetMapping("/getByMatchStrikeRate/{m}/{s}")
	public List<Cricket> getByMatchStrikeRate(@PathVariable("m") int match,@PathVariable("s") int strikeRate){
		return cricketService.getByMatchStrikeRate(match,strikeRate);
	}
	
	@GetMapping("/getNameByTotalRuns/{run}")
	public List<String> getNameByTotalRuns(@PathVariable("run") int run){
		return cricketService.getNameByRuns(run);
	}
	
	@GetMapping("/getByJercyNumber/{jercy}")
	public List<Cricket> getByJercyNumber(@PathVariable("jercy") int jercy) throws PlayerNotFoundException{
		return cricketService.getByJercyNumber(jercy);
	}
	
	@GetMapping("/getById/{id}") 
	public Cricket getById(@PathVariable("id") int id) throws IdNotFoundException {
		return cricketService.getById(id);
	}
	
	
//	@GetMapping("/getGroupByCountry")
//	public List<Cricket> getGroupByCountry(){
//		return cricketService.getGroupByCountry());
//	}
	

}
