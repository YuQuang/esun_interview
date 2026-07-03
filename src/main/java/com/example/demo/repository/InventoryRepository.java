package com.example.demo.repository;

import com.example.demo.model.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
    Optional<InventoryEntity> findByInventoryID(Long inventoryID);
    boolean existsByInventoryID(Long inventoryID);
}
