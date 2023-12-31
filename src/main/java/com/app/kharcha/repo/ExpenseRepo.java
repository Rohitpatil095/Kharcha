package com.app.kharcha.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.kharcha.entity.Expenses;

@Repository
public interface ExpenseRepo extends JpaRepository<Expenses, Integer> {

	List<Expenses> findByUserIdAndCategory(int id,String category, Pageable page);
	List<Expenses> findByUserIdAndName(int id,String name, Pageable page);
	List<Expenses> findByUserIdAndDateBetween(int id,Date startDate, Date endDate, Pageable page);
	
	Page<Expenses> findByUserId(int id, Pageable page);
} 
