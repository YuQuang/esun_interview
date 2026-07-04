package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.InventoryDTO;
import com.example.demo.model.dto.BookLoaningDTO;
import com.example.demo.model.dto.CreateBookDTO;
import com.example.demo.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public CreateBookDTO createBooks(
        @Valid @RequestBody CreateBookDTO createBookDTO
    ) {
        bookService.createBooks(createBookDTO);
        return createBookDTO;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryDTO> getBooks() {
        List<InventoryDTO> books = bookService.getBooks();
        if(books.isEmpty()) {
            throw new IllegalArgumentException("No books found");
        }
        return books;
    }

    @PostMapping("/{id}/loan")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void loanBook(
        @PathVariable Long id,
        Authentication authentication) {
        BookLoaningDTO bookLoaningDTO = new BookLoaningDTO();
        bookLoaningDTO.setInventoryID(id);
        bookService.loanBook(
            authentication.getName(),
            bookLoaningDTO
        );
    }

    @PostMapping("/{id}/return")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void returnBook(
        @PathVariable Long id,
        Authentication authentication) {
        BookLoaningDTO bookLoaningDTO = new BookLoaningDTO();
        bookLoaningDTO.setInventoryID(id);
        bookService.returnBook(
            authentication.getName(),
            bookLoaningDTO
        );
    }
}
