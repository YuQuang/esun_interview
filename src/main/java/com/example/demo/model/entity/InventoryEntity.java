package com.example.demo.model.entity;

import com.example.demo.model.enums.BookStatus;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;


@Entity
@Table(name = "inventory")
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long inventoryID;

    @Column(name = "isbn")
    private String isbn;

    @CreationTimestamp
    @Column(name = "store_time")
    private LocalDateTime storeTime;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    // getter / setter
    public Long getInventoryID() { return inventoryID; }
    public void setInventoryID(Long inventoryID) { this.inventoryID = inventoryID; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public LocalDateTime getStoreTime() { return storeTime; }
    public void setStoreTime(LocalDateTime storeTime) { this.storeTime = storeTime; }

    public BookStatus getStatus() { return status; }
    public void setStatus(BookStatus status) { this.status = status; }
}
