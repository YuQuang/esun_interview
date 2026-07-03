package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.BookLoaningDTO;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
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
}
