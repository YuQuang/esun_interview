package com.example.demo.repository;

import com.example.demo.model.entity.BookEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    // 透過 ISBN 找書
    Optional<BookEntity> findByIsbn(String isbn);
}