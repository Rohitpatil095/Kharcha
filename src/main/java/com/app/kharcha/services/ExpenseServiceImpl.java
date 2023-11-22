package com.app.kharcha.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.kharcha.entity.Expenses;
import com.app.kharcha.repo.ExpenseRepo;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	ExpenseRepo expenseRepo;
	
	@Override
	public List<Expenses> getAllExpenses() {
		return expenseRepo.findAll();
	}

	@Override
	public Expenses getUserExpenseByIdPathVar(int id) {
		Optional<Expenses> exp= expenseRepo.findById(id);
		
		if(exp.isPresent())
		{
			return exp.get();
		}
		return null;
		
	}

	@Override
	public Expenses getUserExpenseByIdQueryString(int id) {
		Optional<Expenses> exp= expenseRepo.findById(id);
		
		if(exp.isPresent())
		{
			return exp.get();
		}
		throw new RuntimeException("Not expense found for particular user->"+ id);

	}

	@Override
	public void deleteUserExpenseById(int id) {
		expenseRepo.deleteById(id);
	}

	@Override
	public Expenses saveUserExpense(Expenses exp) {
		return expenseRepo.save(exp);
	}

	@Override
	public Expenses updateExpense(Expenses exp) {

			Expenses currExp=getUserExpenseByIdPathVar(exp.getId());
			if(currExp.getId()>0)
			{
				currExp.setAmount(currExp.getAmount()!=null  ? exp.getAmount() : currExp.getAmount());
				currExp.setCategory(currExp.getCategory()!=null ?  exp.getCategory() : currExp.getCategory());
				currExp.setDate(currExp.getDate()!=null ?  exp.getDate(): currExp.getDate());
				currExp.setDescription(currExp.getDescription()!=null ? exp.getDescription() :currExp.getDescription());
				currExp.setName(currExp.getName()!=null ? exp.getName() : currExp.getName());
				
			}
			else
			{
				return saveUserExpense(exp);
			}
			return expenseRepo.save(currExp);

	}

}