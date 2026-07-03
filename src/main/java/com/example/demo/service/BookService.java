package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.dto.BookLoaningDTO;
import com.example.demo.model.entity.BorrowingRecordEntity;
import com.example.demo.model.entity.InventoryEntity;
import com.example.demo.model.enums.BookStatus;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

import com.example.demo.repository.BorrowingRecordRepository;

@Service
public class BookService {

    private final InventoryRepository inventoryRepository;
    private final BorrowingRecordRepository borrowingRecordRepository;
    private final UserRepository userRepository;

    public BookService(
        InventoryRepository inventoryRepository,
        BorrowingRecordRepository borrowingRecordRepository,
        UserRepository userRepository
    ) {
        this.inventoryRepository = inventoryRepository;
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void loanBook(
        String phoneNumber,
        BookLoaningDTO bookLoaningDTO
    ) {
        var userOptional = userRepository.findByPhoneNumber(phoneNumber);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        Long userID = userOptional.get().getId();

        Long bookID = bookLoaningDTO.getInventoryID();
        if (!inventoryRepository.existsByInventoryID(bookID)) {
            throw new IllegalArgumentException("Book not found");
        }

        Optional<InventoryEntity> book = inventoryRepository.findByInventoryID(bookID);
        if (book.isEmpty()) {
            throw new IllegalArgumentException("Book not found");
        }
        if (book.get().getStatus() != BookStatus.AVAILABLE) {
            throw new IllegalArgumentException("Book is not available for loan");
        }
        book.get().setStatus(BookStatus.RENTED);
        
        BorrowingRecordEntity borrowingRecord = new BorrowingRecordEntity();
        borrowingRecord.setInventoryID(bookID);
        borrowingRecord.setUserID(userID);
        borrowingRecordRepository.save(borrowingRecord);
    }
}
