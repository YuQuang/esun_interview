package com.example.demo.repository;

import com.example.demo.model.entity.BorrowingRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecordEntity, Long> {
    Optional<BorrowingRecordEntity> findByID(Long id);
}
