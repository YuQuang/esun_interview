package com.example.demo.model.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "borrowing_record")
public class BorrowingRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userID;

    @Column(name = "inventory_id")
    private Long inventoryID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id",
                insertable = false, updatable = false)
    private InventoryEntity inventory;

    @CreationTimestamp
    @Column(name = "borrowing_time")
    private LocalDateTime borrowingTime;

    @Column(name = "return_time")
    private LocalDateTime returnTime;

    // getter / setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserID() { return userID; }
    public void setUserID(Long userID) { this.userID = userID; }

    public Long getInventoryID() { return inventoryID; }
    public void setInventoryID(Long inventoryID) { this.inventoryID = inventoryID; }

    public InventoryEntity getInventory() { return inventory; }
    public void setInventory(InventoryEntity inventory) { this.inventory = inventory; }

    public LocalDateTime getBorrowingTime() { return borrowingTime; }
    public void setBorrowingTime(LocalDateTime borrowingTime) { this.borrowingTime = borrowingTime; }

    public LocalDateTime getReturnTime() { return returnTime; }
    public void setReturnTime(LocalDateTime returnTime) { this.returnTime = returnTime; }
}
