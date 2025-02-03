package com.example.pro.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.annotation.processing.Generated;

import org.springframework.cglib.core.Local;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    public int id;

    @Column(name = "name")
    public String name;  

    @Column(name = "category")
    public String category;

    @Column(name = "price")
    public BigDecimal price;

    @Column(name = "stock")
    public int stock;

    @Column(name = "added_Date")
    public LocalDateTime addedDate;
}
