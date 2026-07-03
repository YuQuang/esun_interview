package com.example.demo.model.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BorrowingRecordDTO {
    
    @JsonProperty("id")
    private Long id;

    @JsonProperty("inventory_id")
    private Long inventoryId;

    @JsonProperty("borrowing_time")
    private LocalDateTime borrowingTime;

    @JsonProperty("return_time")
    private LocalDateTime returnTime;

    @JsonProperty("author")
    private String author;

    @JsonProperty("title")
    private String title;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getInventoryId() { return inventoryId; }
    public void setInventoryId(Long inventoryId) { this.inventoryId = inventoryId; }

    public LocalDateTime getBorrowingTime() { return borrowingTime; }
    public void setBorrowingTime(LocalDateTime borrowingTime) { this.borrowingTime = borrowingTime; }

    public LocalDateTime getReturnTime() { return returnTime; }
    public void setReturnTime(LocalDateTime returnTime) { this.returnTime = returnTime; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
