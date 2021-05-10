package com.examly.springapp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.Model.LibraryBook;
import com.examly.springapp.Repository.LibraryRepository;

@RestController
public class LibraryController {
	
	@Autowired
	private LibraryRepository repository; 
	
	
	@PostMapping("/saveBook")
	public void save_book(@RequestBody LibraryBook book_details) {
		LibraryBook book = new LibraryBook();
		
		book.setBookId(book_details.getBookId());
		book.setBookName(book_details.getBookName());
		book.setGenre(book_details.getGenre());
		book.setQuantity(book_details.getQuantity());
		
		repository.save(book);
	}
	
	@PostMapping("/editBook")
	public void update_book(@RequestParam String bookId, @RequestBody LibraryBook req_book) {
		LibraryBook book = repository.findByBookId(bookId);
		
		book.setBookName(req_book.getBookName());
		book.setGenre(req_book.getGenre());
		book.setQuantity(req_book.getQuantity());
		
		repository.save(book);
		
	}
	
	@PostMapping("/deleteBook")
	public String delete_book(@RequestParam String bookId) {
		repository.deleteById(bookId);
		return "Deleted Successfully";
	}
	
	@GetMapping("/getBooks")
	public List<LibraryBook> get_books() {
		return repository.findAll();
	}
	
	@PostMapping("/getByType")
	public List<LibraryBook> get_book_type(@RequestParam String genre) {
		return repository.findByGenre(genre);
	}
}	
