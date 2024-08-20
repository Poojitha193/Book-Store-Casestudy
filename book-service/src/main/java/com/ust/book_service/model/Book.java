package com.ust.book_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String author;
    private Double price;
    private long stock;

    public Book(String title,String auhtor,Double price,Long stock) {

    }


  /* @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String title;

    @NotNull
    @Size(min = 1, max = 255)
    private String author;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 6, fraction = 2)
    private float price;

    @NotNull
    @Min(0)
    private long stock;

   */
}
