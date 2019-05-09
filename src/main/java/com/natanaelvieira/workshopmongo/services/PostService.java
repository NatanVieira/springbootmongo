package com.natanaelvieira.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natanaelvieira.workshopmongo.domain.Post;
import com.natanaelvieira.workshopmongo.dto.PostDTO;
import com.natanaelvieira.workshopmongo.repository.PostRepository;
import com.natanaelvieira.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public List<Post> findAll(){
		return repo.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
	}
	
	public Post insert(Post obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Post update(Post obj) {
		Post newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	public Post fromDTO(PostDTO objDTO) {
		return new Post(objDTO.getId(), objDTO.getDate(), objDTO.getTitle(), objDTO.getBody(), objDTO.getAuthor());
	}
	
	public void updateData(Post newObj, Post obj) {
		newObj.setAuthor(obj.getAuthor());
		newObj.setBody(obj.getBody());
		newObj.setTitle(obj.getTitle());
		newObj.setDate(obj.getDate());
	}
}
