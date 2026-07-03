package com.example.demo.repository;

import com.example.demo.model.entity.BorrowingRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecordEntity, Long> {
    // 找特定書籍的借閱紀錄，且尚未歸還
    Optional<BorrowingRecordEntity> findByInventoryIDAndUserIDAndReturnTimeIsNull(Long inventoryID, Long userID);

    // 找特定書籍的借閱紀錄，且已歸還
    Optional<BorrowingRecordEntity> findByInventoryIDAndUserIDAndReturnTimeIsNotNull(Long inventoryID, Long userID);

    // 找特定使用者的所有借閱紀錄，且尚未歸還
    List<BorrowingRecordEntity> findByUserIDAndReturnTimeIsNull(Long userID);
}
