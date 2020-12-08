package com.noteappreact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noteappreact.model.Login;





@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
	
	//@Query("SELECT l FROM Login l WHERE l.userName = ?1")
	Login findByUserName(String userName);
}

