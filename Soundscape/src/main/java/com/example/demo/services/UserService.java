package com.example.demo.services;

import com.example.demo.entities.Users;

public interface UserService {
	public String addUser(Users user) ;
	public boolean emailExists(String email);
	public boolean validateUser(String email, String password);
	public String getRole(String email);
	public Users getObject(String email);
	public void updateUser(Users user);

}
