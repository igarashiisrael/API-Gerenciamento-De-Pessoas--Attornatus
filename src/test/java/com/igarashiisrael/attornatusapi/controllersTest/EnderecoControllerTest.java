package com.igarashiisrael.attornatusapi.controllersTest;

import com.igarashiisrael.attornatusapi.controllers.EnderecoController;
import com.igarashiisrael.attornatusapi.models.EnderecoModel;
import com.igarashiisrael.attornatusapi.repositories.EnderecoRepository;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EnderecoControllerTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Mock
    private EnderecoRepository repository;

    @InjectMocks
    private EnderecoController controller;

    @Test
    public void criarEndereco_deveRetornarEnderecoCriado() {

        EnderecoModel endereco = new EnderecoModel();
        endereco.setLogradouro("Rua A");
        endereco.setNumero("123");
        endereco.setCidade("São Paulo");
        endereco.setCep("12345-678");
        endereco.setEnderecoPrincipal(true);

        when(repository.save(endereco)).thenReturn(endereco);

        ResponseEntity<EnderecoModel> response = controller.criarEndereco(endereco);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals("Rua A", response.getBody().getLogradouro());
        Assertions.assertEquals("123", response.getBody().getNumero());
        Assertions.assertEquals("São Paulo", response.getBody().getCidade());
        Assertions.assertEquals("12345-678", response.getBody().getCep());
        Assertions.assertTrue(response.getBody().isEnderecoPrincipal());
    }

}