package com.example.pro.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID
    private Long id;

    private String name;

    private String type;

    @Lob // Specifies large binary data
    private byte[] imageData;

    // Constructors
    public Image() {}

    public Image(String name, String type, byte[] imageData) {
        this.name = name;
        this.type = type;
        this.imageData = imageData;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
