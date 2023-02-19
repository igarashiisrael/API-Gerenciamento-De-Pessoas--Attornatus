# API-Gerenciamento-De-Pessoas--Attornatus

API Gerenciamento de Pessoas - Attornatus

Esta API é um sistema de gerenciamento de pessoas que foi desenvolvido utilizando a linguagem de programação Java e o framework Spring Boot. 
Ela permite que sejam criados registros de pessoas contendo informações como nome, data de nascimento e endereço.

Clone o repositório em sua máquina local:
git clone https://github.com/igarashiisrael/API-Gerenciamento-De-Pessoas--Attornatus.git


Endpoints disponíveis:

#Pessoas:

GET /pessoas: Retorna uma lista com todas as pessoas cadastradas no sistema.

GET /pessoas/nome/{nome}: Retorna uma pessoa específica pelo seu nome.

POST /pessoas/criarPessoa: Cria uma nova pessoa no sistema.

PUT /pessoas/editarPessoa: Atualiza uma pessoa existente no sistema pelo seu ID.

DELETE /pessoas/{id}: Deleta uma pessoa do sistema pelo seu ID.

-----------------------------------------------------------------------------------

#Endereços:

GET /enderecos: Retorna uma lista com todos os endereços cadastrados no sistema.

POST /enderecos/criarEndereco: Cria um novo endereço no sistema.

GET /enderecos/{id}: Retorna um endereço especifico pelo seu ID.

PUT /enderecos/editarEndereco: Atualiza um endereço existente no sistema.

Delete /enderecos/{id}: Deleta um endereço do sistema pelo seu ID.
