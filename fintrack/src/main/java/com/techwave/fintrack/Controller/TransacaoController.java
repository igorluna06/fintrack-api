package com.techwave.fintrack.Controller;

import com.techwave.fintrack.model.Categoria;
import com.techwave.fintrack.model.Transacao;
import com.techwave.fintrack.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @GetMapping
    public List<Transacao> listar(){ return service.listar();}

    @GetMapping("/{id}")
    public Optional<Transacao> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public Transacao Salvar(@RequestBody Transacao transacao){
        return service.salvar(transacao);
    }

    @PutMapping("/{id}")
    public Transacao atualizar(@PathVariable Long id, @RequestBody Transacao transacao){
        return service.atualizar(id, transacao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){service.deletar(id);}
}
