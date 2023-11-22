package com.app.kharcha.services;

import java.util.List;

import com.app.kharcha.entity.Expenses;

public interface ExpenseService {
	public List<Expenses> getAllExpenses();
	public Expenses getUserExpenseByIdPathVar(int id);
	public Expenses getUserExpenseByIdQueryString(int id);
	public void deleteUserExpenseById(int id);
	public Expenses saveUserExpense(Expenses exp);
	public Expenses updateExpense(Expenses exp);
}
