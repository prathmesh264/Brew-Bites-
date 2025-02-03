package com.example.pro.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pro.Entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}

