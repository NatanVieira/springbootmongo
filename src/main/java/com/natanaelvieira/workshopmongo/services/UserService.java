package com.natanaelvieira.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natanaelvieira.workshopmongo.domain.User;
import com.natanaelvieira.workshopmongo.dto.UserDTO;
import com.natanaelvieira.workshopmongo.repository.UserRepository;
import com.natanaelvieira.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired 
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	public void updateData(User newObj, User obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setName(obj.getName());
	}
}
