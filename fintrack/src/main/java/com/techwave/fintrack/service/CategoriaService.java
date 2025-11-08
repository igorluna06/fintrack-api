package com.techwave.fintrack.service;

import com.techwave.fintrack.model.Categoria;
import com.techwave.fintrack.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> listar(){
        return repository.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id){
        return repository.findById(id);
    }

    public Categoria salvar(Categoria categoria){
        return repository.save(categoria);
    }

    public Categoria atualizar(Long id, Categoria categoriaAtualizada){
        return repository.findById(id)
                .map(categoria -> {
                    categoria.setNome(categoriaAtualizada.getNome());
                    return repository.save(categoria);
                })
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

}
