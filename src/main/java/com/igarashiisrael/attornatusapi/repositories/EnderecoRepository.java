package com.igarashiisrael.attornatusapi.repositories;

import com.igarashiisrael.attornatusapi.models.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {
}