package com.example.demo.model.dto;

import java.time.LocalDateTime;

import com.example.demo.model.enums.BookStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class BookDTO {
    
    @JsonProperty("inventory_id")
    private Long inventoryID;

    @JsonProperty("title")
    private String title;

    @JsonProperty("author")
    private String author;

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("store_time")
    private LocalDateTime storeTime;

    @JsonProperty("status")
    @Enumerated(EnumType.STRING)
    private BookStatus status;


    public Long getInventoryID() { return inventoryID; }
    public void setInventoryID(Long inventoryID) { this.inventoryID = inventoryID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public LocalDateTime getStoreTime() { return storeTime; }
    public void setStoreTime(LocalDateTime storeTime) { this.storeTime = storeTime; }

    public BookStatus getStatus() { return status; }
    public void setStatus(BookStatus status) { this.status = status; }
}
