package com.example.demo.domain.card;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    <T> List<T> findByName(String name, Class<T> type);
}
