package com.app.kharcha.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.kharcha.entity.Expenses;

public interface ExpenseService {
	public List<Expenses> getAllExpenses();
	public Expenses getUserExpenseByIdPathVar(int id);
	public Expenses getUserExpenseByIdQueryString(int id);
	public void deleteUserExpenseById(int id);
	public Expenses saveUserExpense(Expenses exp);
	public Expenses updateExpense(Expenses exp);
	
	// pageable
	public Page<Expenses> getAllExpensesByPageble(Pageable page);
}
