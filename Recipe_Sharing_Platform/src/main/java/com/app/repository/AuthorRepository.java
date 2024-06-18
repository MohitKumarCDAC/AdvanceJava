package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
