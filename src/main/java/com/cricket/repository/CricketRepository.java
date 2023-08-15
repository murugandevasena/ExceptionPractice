package com.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.cricket.entity.Cricket;

public interface CricketRepository extends JpaRepository<Cricket, Integer> {

	@Query(value="select * from players_data where age between ? and ?",nativeQuery=true)
	List<Cricket> getByAgeRange(int age1, int age2);

	@Query(value="select * from players_data where n_team_name = ?",nativeQuery=true)
	List<Cricket> getByCountry(String country);

	@Query(value="select name from players_data where total_runs >= ?",nativeQuery=true)
	List<String> getNameByRuns(int run);

	@Query(value="select * from players_data where jercy_no = ?",nativeQuery=true)
	List<Cricket> getByJercyNumber(int jercy);

}

