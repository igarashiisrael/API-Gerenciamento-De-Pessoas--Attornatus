package com.igarashiisrael.attornatusapi.repositories;

import com.igarashiisrael.attornatusapi.models.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
    public List<PessoaModel> findAllByNomeContainingIgnoreCase(String nome);
}
