package com.igarashiisrael.attornatusapi.controllers;

import com.igarashiisrael.attornatusapi.models.PessoaModel;
import com.igarashiisrael.attornatusapi.repositories.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "*")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @GetMapping
    public ResponseEntity<List<PessoaModel>>buscarTodasPessoas() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<PessoaModel>>buscarPessoaPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
    }

    @PostMapping("/criarPessoa")
    public ResponseEntity<PessoaModel> post(@Valid @RequestBody PessoaModel pessoa) {
        pessoa.atualizarContatos();
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(pessoa));
    }

    @PutMapping("/editarPessoa")
    public ResponseEntity<PessoaModel> atualizarPessoa(@Valid @RequestBody PessoaModel pessoa) {
        return repository.findById(pessoa.getPessoaId())
                .map(resp -> ResponseEntity.ok().body(repository.save(pessoa)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletarPessoa(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
