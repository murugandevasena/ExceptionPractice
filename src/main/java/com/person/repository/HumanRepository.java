package com.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.person.entity.Human;

public interface HumanRepository extends JpaRepository<Human, Integer> {
	@Query(value="Select * from human_details",nativeQuery=true)
	List<Human> getAll();

	@Query(value="select * from human_details where name=?",nativeQuery=true)
	List<Human> getByName(String name);

	@Query(value="select * from human_details where age between ? and ?",nativeQuery=true)
	List<Human> getByAgeRange(int age, int age1);

}
