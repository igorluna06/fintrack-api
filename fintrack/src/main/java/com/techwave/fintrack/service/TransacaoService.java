package com.techwave.fintrack.service;


import com.techwave.fintrack.exception.BadRequestException;
import com.techwave.fintrack.exception.ResourceNotFoundException;
import com.techwave.fintrack.model.Categoria;
import com.techwave.fintrack.model.Transacao;
import com.techwave.fintrack.repository.CategoriaRepository;
import com.techwave.fintrack.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository repository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Transacao> listar(){ return repository.findAll();}

    public Optional<Transacao> buscarPorId(Long id){ return repository.findById(id);}

    public Transacao salvar(Transacao transacao){
        if(transacao.getCategoria() == null || transacao.getCategoria().getId() == null){
            throw new BadRequestException("A categoria é obrigatória");
        }

        Categoria categoria = categoriaRepository.findById(transacao.getCategoria().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

        transacao.setCategoria(categoria);

        return repository.save(transacao);
    }

    public Transacao atualizar(Long id, Transacao transacaoAtualizada){
        return repository.findById(id)
                .map(transacao -> {
                    transacao.setDescricao(transacaoAtualizada.getDescricao());
                    transacao.setValor(transacaoAtualizada.getValor());
                    transacao.setData(transacaoAtualizada.getData());
                    transacao.setCategoria(transacaoAtualizada.getCategoria());
                    return repository.save(transacao);
                })
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
