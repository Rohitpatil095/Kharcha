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
	private String name;
	
	@Column(name="expense_description")
	private String description;
	
	@Column(name="expense_amount")
	private BigDecimal amount;
	
	private String category;
	private Date date;
	
	@Column(name="create_date", updatable = false, nullable = false)
	@CurrentTimestamp
	private Timestamp createdDate;
	
	@Column(name="update_date")
	@UpdateTimestamp
	private Timestamp updatedDate;
	
}
