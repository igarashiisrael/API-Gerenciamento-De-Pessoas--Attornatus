package com.igarashiisrael.attornatusapi.controllers;

import com.igarashiisrael.attornatusapi.models.EnderecoModel;
import com.igarashiisrael.attornatusapi.repositories.EnderecoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/enderecos")
@CrossOrigin(origins = "*")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;

    @GetMapping
    public ResponseEntity<List<EnderecoModel>> buscarTodosEnderecos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoModel>buscarEnderecoPorId(@PathVariable Long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/criarEndereco")
    public ResponseEntity<EnderecoModel> criarEndereco(@Valid @RequestBody EnderecoModel endereco){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(endereco));
    }

    @PutMapping("/editarEndereco")
    public ResponseEntity<EnderecoModel> atualizarEndereco(@Valid @RequestBody EnderecoModel endereco){
        return repository.findById(endereco.getEnderecoId())
                .map(resp -> ResponseEntity.ok().body(repository.save(endereco)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletarEndereco(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
