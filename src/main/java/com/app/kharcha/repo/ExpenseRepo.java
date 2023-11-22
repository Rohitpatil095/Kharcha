package com.app.kharcha.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.kharcha.entity.Expenses;

@Repository
public interface ExpenseRepo extends JpaRepository<Expenses, Integer> {

	
	
}
