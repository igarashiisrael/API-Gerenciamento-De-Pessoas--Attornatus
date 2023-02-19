# API-Gerenciamento-De-Pessoas--Attornatus

API Gerenciamento de Pessoas - Attornatus

Esta API é um sistema de gerenciamento de pessoas que foi desenvolvido utilizando a linguagem de programação Java e o framework Spring Boot. 
Ela permite que sejam criados registros de pessoas contendo informações como nome, data de nascimento e endereço.

Clone o repositório em sua máquina local:
git clone https://github.com/igarashiisrael/API-Gerenciamento-De-Pessoas--Attornatus.git


Endpoints disponíveis:

#Pessoas:

POST /pessoas/criarPessoa: Cria uma nova pessoa no sistema.

```
/pessoas/criarPessoa

{
    "nome": "Maria",
    "dataNascimento": "1990-01-01",
    "endereco": [
        {
            "logradouro": "Rua A",
            "numero": "123",
            "cidade": "São Paulo",
            "cep": "12345-678",
            "enderecoPrincipal": true
        },
                {
            "logradouro": "Rua B",
            "numero": "456",
            "cidade": "São Paulo",
            "cep": "12345-901",
            "enderecoPrincipal": false
        }
    ]
}

```

GET: /pessoas Retorna uma lista com todas as pessoas cadastradas no sistema.

```
/pessoas
```

GET /pessoas/nome/{nome}: Retorna uma pessoa específica pelo seu nome.

```
/pessoas/nome/Maria
```

PUT /pessoas/editarPessoa: Atualiza uma pessoa existente no sistema pelo seu ID.

```
/pessoas/editarPessoa

{
    "pessoaId": 1,
    "nome": "João",
    "dataNascimento": "1993-01-01"
}
```

DELETE /pessoas/{id}: Deleta uma pessoa do sistema pelo seu ID.

```
/pessoas/1
```

-----------------------------------------------------------------------------------

#Endereços:

POST /enderecos/criarEndereco: Cria um novo endereço no sistema.

```
/enderecos/criarEndereco

{        
        "logradouro": "Av vila Ema",
        "cep": "12345-678",
        "numero": "4868",
        "cidade": "São Paulo",
        "enderecoPrincipal": false      
}
```

GET /enderecos: Retorna uma lista com todos os endereços cadastrados no sistema.

```
/enderecos
```

GET /enderecos/{id}: Retorna um endereço especifico pelo seu ID.

```
/enderecos/1
```

PUT /enderecos/editarEndereco: Atualiza um endereço existente no sistema.

```
/enderecos/editarEndereco

{
    "enderecoId": 1,
    "logradouro": "Rua Vinte e Cinco de Março",
    "cep": "03156-001",
    "numero": "321",
    "cidade": "São Paulo",
    "enderecoPrincipal": true
}
```

Delete /enderecos/{id}: Deleta um endereço do sistema pelo seu ID.

```
/enderecos/1
```

