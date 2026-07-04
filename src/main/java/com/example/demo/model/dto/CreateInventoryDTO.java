package com.example.demo.model.dto;

import java.time.LocalDateTime;

import com.example.demo.model.enums.BookStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CreateInventoryDTO {
    @JsonProperty("isbn")
    @NotBlank(message = "ISBN 不可為空")
    @Pattern(
        regexp = "^\\d{13}$",
        message = "ISBN 必須為 13 位數字"
    )
    private String isbn;

    @JsonProperty("store_time")
    private LocalDateTime storeTime;

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public LocalDateTime getStoreTime() { return storeTime; }
    public void setStoreTime(LocalDateTime storeTime) { this.storeTime = storeTime; }
}
