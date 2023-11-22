package com.app.kharcha.entity;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.Date;

import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Expenses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "expense_name")
	@NotBlank(message = "Expense Name Should not be null or empty")
	@Size(min = 2, message = "Expense name should be atleast 2 letters long")
	private String name;
	
	@Column(name="expense_description")
	private String description;
	
	@Column(name="expense_amount")
	@NotNull
	private BigDecimal amount;
	
	@NotBlank(message = "Provide category for expense")
	private String category;
	private Date date;
	
//	@Column(name="create_date", updatable = false, nullable = false)
//	@CurrentTimestamp
//	private Timestamp createdDate;
//	
//	@Column(name="update_date")
//	@UpdateTimestamp
//	private Timestamp updatedDate;
	
}
