package com.example.demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateBookDTO {
    @JsonProperty("name")
    @NotBlank(message = "NAME 不可為空")
    private String name;

    @JsonProperty("author")
    private String author;

    @JsonProperty("isbn")
    @NotBlank(message = "ISBN 不可為空")
    @Pattern(
        regexp = "^\\d{13}$",
        message = "ISBN 必須為 13 位數字"
    )
    private String isbn;

    @JsonProperty("introduction")
    private String introduction;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getIntroduction() { return introduction; }
    public void setIntroduction(String introduction) { this.introduction = introduction; }
}
