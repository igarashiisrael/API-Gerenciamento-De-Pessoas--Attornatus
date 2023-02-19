package com.igarashiisrael.attornatusapi.controllersTest;

import com.igarashiisrael.attornatusapi.controllers.PessoaController;
import com.igarashiisrael.attornatusapi.models.EnderecoModel;
import com.igarashiisrael.attornatusapi.models.PessoaModel;
import com.igarashiisrael.attornatusapi.repositories.PessoaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaControllerTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaController pessoaController;

    @Test
    void buscarTodasPessoas_deveRetornarListaDePessoas() {
        List<PessoaModel> pessoas = new ArrayList<>();
        pessoas.add(new PessoaModel(1L, "João", LocalDate.of(1990, 01, 01)));
        pessoas.add(new PessoaModel(2L, "Maria", LocalDate.of(1995, 05, 15)));

        Mockito.when(pessoaRepository.findAll()).thenReturn(pessoas);

        ResponseEntity<List<PessoaModel>> responseEntity = pessoaController.buscarTodasPessoas();
        List<PessoaModel> pessoasRetornadas = responseEntity.getBody();

        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertNotNull(pessoasRetornadas);
        Assertions.assertEquals(pessoas.size(), pessoasRetornadas.size());
        Assertions.assertEquals(pessoas.get(0).getNome(), pessoasRetornadas.get(0).getNome());
        Assertions.assertEquals(pessoas.get(0).getDataNascimento(), pessoasRetornadas.get(0).getDataNascimento());
        Assertions.assertEquals(pessoas.get(1).getNome(), pessoasRetornadas.get(1).getNome());
        Assertions.assertEquals(pessoas.get(1).getDataNascimento(), pessoasRetornadas.get(1).getDataNascimento());
    }

    @Test
    public void criarPessoa_deveRetornarPessoaCriada() {

        PessoaModel pessoa = new PessoaModel();
        pessoa.setNome("João");
        pessoa.setDataNascimento(LocalDate.of(1990, 1, 1));

        EnderecoModel endereco = new EnderecoModel();
        endereco.setLogradouro("Rua A");
        endereco.setNumero("123");
        endereco.setCidade("São Paulo");
        endereco.setCep("12345-678");
        endereco.setEnderecoPrincipal(true);
        endereco.setPessoa(pessoa);

        pessoa.setEndereco(Arrays.asList(endereco));

        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        ResponseEntity<PessoaModel> response = pessoaController.criarPessoa(pessoa);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals("João", response.getBody().getNome());
        Assertions.assertEquals(LocalDate.of(1990, 1, 1), response.getBody().getDataNascimento());
        Assertions.assertEquals(1, response.getBody().getEndereco().size());
        Assertions.assertEquals("Rua A", response.getBody().getEndereco().get(0).getLogradouro());
        Assertions.assertEquals("123", response.getBody().getEndereco().get(0).getNumero());
        Assertions.assertEquals("São Paulo", response.getBody().getEndereco().get(0).getCidade());
        Assertions.assertEquals("12345-678", response.getBody().getEndereco().get(0).getCep());
        Assertions.assertTrue(response.getBody().getEndereco().get(0).isEnderecoPrincipal());
    }
}

