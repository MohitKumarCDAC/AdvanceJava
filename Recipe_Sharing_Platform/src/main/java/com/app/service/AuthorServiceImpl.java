package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Author;
import com.app.repository.AuthorRepository;
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public Author addAuthor(Author author) {
		
		return authorRepository.save(author);
	}

	@Override
	public List<Author> getAllAuthor() {
		return authorRepository.findAll();
	}

	

}
