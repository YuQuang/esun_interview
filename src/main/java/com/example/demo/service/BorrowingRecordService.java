package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.dto.BorrowingRecordDTO;
import com.example.demo.repository.BorrowingRecordRepository;
import com.example.demo.repository.UserRepository;

@Service
public class BorrowingRecordService {

    private final BorrowingRecordRepository borrowingRecordRepository;
    private final UserRepository userRepository;

    public BorrowingRecordService(
        BorrowingRecordRepository borrowingRecordRepository,
        UserRepository userRepository) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.userRepository = userRepository;
    }

    public List<BorrowingRecordDTO> getBorrowedBooks(
        String phoneNumber
    ) {
        var userOptional = userRepository.findByPhoneNumber(phoneNumber);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        Long userID = userOptional.get().getId();

        return borrowingRecordRepository
            .findByUserIDAndReturnTimeIsNull(userID).stream()
            .map(borrowingRecordEntity -> {
                BorrowingRecordDTO borrowingRecordDTO = new BorrowingRecordDTO();
                borrowingRecordDTO.setId(borrowingRecordEntity.getId());
                borrowingRecordDTO.setBorrowingTime(borrowingRecordEntity.getBorrowingTime());
                borrowingRecordDTO.setInventoryId(borrowingRecordEntity.getInventoryID());
                borrowingRecordDTO.setAuthor(borrowingRecordEntity.getInventory().getBook().getAuthor());
                borrowingRecordDTO.setTitle(borrowingRecordEntity.getInventory().getBook().getName());
                borrowingRecordDTO.setReturnTime(borrowingRecordEntity.getReturnTime());
                return borrowingRecordDTO;
            }).toList();
    }
}
