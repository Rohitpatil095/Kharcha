package com.app.kharcha.entity;

import lombok.Data;

@Data
public class UserModel {
	private String name;
	private String email;
	private int age=0;
	private String password;
}
