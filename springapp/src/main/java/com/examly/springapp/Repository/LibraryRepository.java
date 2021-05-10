package com.examly.springapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.Model.LibraryBook;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryBook, String> {
	LibraryBook findByBookId(String bookId);
	List<LibraryBook> findByGenre(String genre);
}	
