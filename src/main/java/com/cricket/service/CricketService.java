package com.cricket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.dao.CricketDao;
import com.cricket.entity.Cricket;
import com.cricket.userdefinedexception.IdNotFoundException;
import com.cricket.userdefinedexception.JercyNotFoundException;
import com.cricket.userdefinedexception.PlayerNotFoundException;

@Service
public class CricketService {
	@Autowired
	CricketDao cricketDao;
	List<Cricket> l1;
	List<Cricket> l2;
	public String setOne(Cricket cricket) throws JercyNotFoundException {
		// TODO Auto-generated method stub
		cricket.setTotalRuns(cricket.getIplRuns() + cricket.getN5050Runs() + cricket.gettTwentyRuns());
		l1 = getAll();
//		try {
		for (Cricket c : l1) {
			if (c.getJercyNo() == cricket.getJercyNo()) {
				throw new JercyNotFoundException(
						"Jercy number " + cricket.getJercyNo() + " is already in DB.Please assign new one.");
			} 
		}
		return cricketDao.setOne(cricket);
//		}
//		catch (Exception e) {
//			return "Jercy number already exits";
//		}		
	}

	public String setMany(List<Cricket> cricket) throws JercyNotFoundException {
		// TODO Auto-generated method
		/* Both for and forEcah are working well */
//	    int total=0;
//		for(int i=0;i<cricket.size();i++) {
//		total= cricket.get(i).getIplRuns()+cricket.get(i).getN5050Runs()+cricket.get(i).gettTwentyRuns();	
//		cricket.get(i).setTotalRuns(total);
//		}
//		return cricketDao.setMany(cricket);

		cricket.forEach(x -> {
			x.setTotalRuns(x.getIplRuns() + x.getN5050Runs() + x.gettTwentyRuns());
		});
//		
//		l1=getAll();
//		List<Cricket> l3 = l1.stream().filter(x->(x.getJercyNo()!= cricket.forEach(y->{
//			y.getJercyNo();
//		});
		return cricketDao.setMany(cricket);

	}

	public List<Cricket> getAll() {
		// TODO Auto-generated method stub
		return cricketDao.getAll();
	}

	public List<Cricket> getByAgeRange(int age1, int age2) {
		// TODO Auto-generated method stub
		return cricketDao.getByAgeRange(age1, age2);
	}

	public List<Cricket> getByCountry(String country) {
		// TODO Auto-generated method stub
		return cricketDao.getByCountry(country);
	}

	public List<Cricket> getByMatchStrikeRate(int match, int strikeRate) {
		// TODO Auto-generated method stub
		List<Cricket> l1 = getAll();
		List<Cricket> cricket = l1.stream().filter(x -> x.getMatchPlayed() > match && x.getStrikeRate() > strikeRate)
				.collect(Collectors.toList());
		return cricket;
	}

	public List<String> getNameByRuns(int run) {
		// TODO Auto-generated method stub
		return cricketDao.getNameByRuns(run);
	}

	public List<Cricket> getByJercyNumber(int jercy) throws PlayerNotFoundException {
		// TODO Auto-generated method stub
		List<Cricket> c= cricketDao.getByJercyNumber(jercy);
		if(c.isEmpty()) {
			throw new PlayerNotFoundException(
					"Player " + jercy + " is not found.");
		}
		else
		{
			return c;
		}
	}

	public Cricket getById(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Print id:"+id);
		return cricketDao.getById(id);
		
	}

//	public List<Cricket> getGroupByCountry() {
//		// TODO Auto-generated method stub
//		 l1 = getAll();
//		 long cricket = l1.stream().filter(x->x.getnTeamName()).count();
//		return null;
//	}
}
