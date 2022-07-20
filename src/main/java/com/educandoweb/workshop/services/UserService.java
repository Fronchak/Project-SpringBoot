package com.educandoweb.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.repositories.UserRepository;
import com.educandoweb.workshop.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	public User update(Long id, User user) {
		User entity = userRepository.getReferenceById(id);	
		updateData(entity, user);
		return userRepository.save(entity);
	}
	
	private void updateData(User updatedUser, User referenceUser) {
		updatedUser.setEmail(referenceUser.getEmail());
		updatedUser.setName(referenceUser.getName());
		updatedUser.setPhone(referenceUser.getPhone());
	}
}
