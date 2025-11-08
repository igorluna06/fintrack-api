package com.techwave.fintrack.repository;

import com.techwave.fintrack.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
