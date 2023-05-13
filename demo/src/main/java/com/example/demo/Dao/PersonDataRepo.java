package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PersonEntity;

@Repository
public interface PersonDataRepo extends JpaRepository<PersonEntity, Long> {
	
	List<PersonEntity> findByAddress(String address);
	
	List<PersonEntity> findByName(String name);

}
