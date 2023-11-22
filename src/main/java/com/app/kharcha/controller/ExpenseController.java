package com.app.kharcha.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.kharcha.entity.Expenses;
import com.app.kharcha.services.ExpenseService;

import jakarta.validation.Valid;

@RestController
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/expenses/all")
	public List<Expenses> listAllExpenses()
	{
		return expenseService.getAllExpenses(); 
	}
	
	// ---- adding paginatio feature ---
	@GetMapping("/expenses/pageble/all")
	public Page<Expenses> listAllExpensesInPage(Pageable page)
	{
		return expenseService.getAllExpensesByPageble(page);
	}
	
	// pathvariable to get user id 
	@GetMapping("/expenses/{userId}")
	public Expenses getExpensesUsingIdPathVar(@PathVariable("userId") int id)
	{
		return expenseService.getUserExpenseByIdPathVar(id);
	}
	
	// USING query string 
	@GetMapping("/expenses")
	public Expenses getExpensesUsingIdQueryString(@RequestParam("userId") int id)
	{
		return expenseService.getUserExpenseByIdQueryString(id);
	}
	
	// delete expense by userid 
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@DeleteMapping("/expenses/{userId}")
	public void deleteUserExpenseById(@PathVariable("userId") int userId)
	{
		expenseService.deleteUserExpenseById(userId);
//		return HttpStatus.ACCEPTED;
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value="/expenses", consumes = {"application/json"})
	public Expenses saveUserExpense(@Valid @RequestBody Expenses exp)
	{
		return expenseService.saveUserExpense(exp);
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PutMapping(value="/expenses", consumes = {"application/json"})
	public Expenses updateOrCreateUserExpense(@RequestBody Expenses exp)
	{
		return expenseService.updateExpense(exp);
	}
	
	@GetMapping("/expenses/category")
	public List<Expenses> getExpensesByCategory(@RequestParam String category,Pageable page)
	{
		return expenseService.filterExpenseByCategory(category, page);
	}
	
	@GetMapping("/expenses/name")
	public List<Expenses> getExpensesByName(@RequestParam String name, Pageable page)
	{
		return expenseService.filterExpensesByName(name, page);
	}
	
	@GetMapping("/expenses/date")
	public List<Expenses> getExpensesBetweenDates(@RequestParam(required = false) Date startDate, @RequestParam(required = false) Date endDate, Pageable page)
	{
		return expenseService.filterExpenseByDate(startDate, endDate, page);
	}
}  
