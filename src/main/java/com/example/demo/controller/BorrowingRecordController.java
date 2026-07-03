package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.BorrowingRecordDTO;
import com.example.demo.service.BorrowingRecordService;

@RestController
@RequestMapping("/api/borrowing-record")
public class BorrowingRecordController {
    private final BorrowingRecordService borrowingRecordService;

    public BorrowingRecordController(BorrowingRecordService borrowingRecordService) {
        this.borrowingRecordService = borrowingRecordService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<BorrowingRecordDTO> getBorrowedBooks(
        Authentication authentication) {
        return borrowingRecordService.getBorrowedBooks(
            authentication.getName()
        );
    }
}
