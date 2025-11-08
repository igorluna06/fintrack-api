package com.techwave.fintrack.Controller;

import com.techwave.fintrack.model.Categoria;
import com.techwave.fintrack.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<Categoria> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public Categoria Salvar(@RequestBody Categoria categoria){
        return service.salvar(categoria);
    }

    @PutMapping("/{id}")
    public Categoria atualizar(@PathVariable Long id, @RequestBody Categoria categoria){
        return service.atualizar(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
