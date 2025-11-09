package com.techwave.fintrack.repository;

import com.techwave.fintrack.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
