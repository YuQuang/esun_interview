package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookLoaningDTO {
    
    @JsonProperty("inventory_id")
    private Long inventoryID;

    public Long getInventoryID() {
        return inventoryID;
    }
    public void setInventoryID(Long inventoryID) {
        this.inventoryID = inventoryID;
    }
}
