package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UserRepository;

@Service
public class UsersServiceImp implements UserService {
    @Autowired
    UserRepository repo;

    @Override
    public String addUser(Users user) {
        repo.save(user);
        return "user is created and saved";
    }

    @Override
    public boolean emailExists(String email) {
        return repo.findByEmail(email) != null;
    }

    @Override
    public boolean validateUser(String email, String password) {
        Users user = repo.findByEmail(email);
        if (user == null) {
            return false; // User not found
        }
        return user.getPassword().equals(password);
    }

    @Override
    public String getRole(String email) {
        Users user = repo.findByEmail(email);
        if (user == null) {
            return "unknown"; // or handle appropriately
        }
        return user.getRole();
    }

	public Users getObject(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
		// TODO Auto-generated method stub
		
	}
}
