package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.dto.CreateInventoryDTO;
import com.example.demo.model.dto.InventoryDTO;
import com.example.demo.model.entity.BookEntity;
import com.example.demo.model.entity.InventoryEntity;
import com.example.demo.model.enums.BookStatus;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.InventoryRepository;

@Service
public class InventoryService {
    
    private final InventoryRepository inventoryRepository;
    private final BookRepository bookRepository;

    public InventoryService(
        InventoryRepository inventoryRepository,
        BookRepository bookRepository
    ) {
        this.inventoryRepository = inventoryRepository;
        this.bookRepository = bookRepository;
    }

    public InventoryDTO createInventory(CreateInventoryDTO createInventoryDTO){
        InventoryEntity inventoryEntity = new InventoryEntity();
        Optional<BookEntity> optionBookEntity = bookRepository.findByIsbn(createInventoryDTO.getIsbn());
        if(optionBookEntity.isEmpty()){
            throw new IllegalArgumentException("Book not found");
        }
        inventoryEntity.setIsbn(createInventoryDTO.getIsbn());
        inventoryEntity.setStatus(BookStatus.AVAILABLE);
        inventoryRepository.save(inventoryEntity);

        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setAuthor(optionBookEntity.get().getAuthor());
        inventoryDTO.setIsbn(optionBookEntity.get().getIsbn());
        inventoryDTO.setStatus(BookStatus.AVAILABLE);
        inventoryDTO.setTitle(optionBookEntity.get().getName());
        inventoryDTO.setInventoryID(inventoryEntity.getInventoryID());
        inventoryDTO.setStoreTime(inventoryEntity.getStoreTime());

        return inventoryDTO;
    }
}
