package com.ust.book_service.dto;

import jakarta.validation.constraints.*;

public record BookDto(
                      @NotEmpty(message = "Book title can't be null")
                      @Size(max = 255, message = "Author name must not exceed 50 characters")
                      String bookTitle,

                      @NotEmpty(message = "Author name can't be null")
                      @Size(min = 1, max = 255, message = "Author name must not exceed 50 characters")
                      String author,

                      @NotEmpty(message =  "Price cannot be Empty")
                      @Positive(message = "Price must be greater than 0")
                      @DecimalMax(value = "9999999.99")
                      Double price,

                      @NotEmpty(message = "Stock must be provided")
                      @Min(value = 0, message = "Stock must be 0 or more")
                      long stock

) { }