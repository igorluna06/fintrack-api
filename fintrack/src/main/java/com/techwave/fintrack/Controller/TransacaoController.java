package com.techwave.fintrack.Controller;

import com.techwave.fintrack.model.Categoria;
import com.techwave.fintrack.model.Transacao;
import com.techwave.fintrack.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Transacao> Salvar(@Valid @RequestBody Transacao transacao){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(transacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacao> atualizar(@PathVariable Long id,@Valid @RequestBody Transacao transacao){
        return ResponseEntity.ok(service.atualizar(id, transacao));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){service.deletar(id);}
}
