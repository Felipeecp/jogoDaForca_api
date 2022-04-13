# JogoDaForca

Projeto desenvolvido durante programa de estagio empresa [Techne](https://www.techne.com.br/)

## Descrição

A proposta do desafio foi criar um site com um protótipo de jogo da forca.
O site deveria ter:

- Tela de login com autenticação do usuário cadastrado no banco dados;
- Tela de cadastro de novos usuário;
- Na tela de cadastro, ter campos de endereço (CEP, Cidade e Estado) e campos relacionados a cartão de crédito;
- Tela do Jogo com toda a lógica para funcionamento do jogo;

## Sobre a API

Esta API REST foi desenvolvida para ser consumida pelo Frontend da aplicação (que pode ser acessado neste [repositorio](https://github.com/Felipeecp/jogoDaForca_angular))

**Principais Rotas:**
Palavras:
* `GET` - Obter lista de palavras cadastradas no banco de dados
* `POST` - Cadastrar novas palavras, com nome e categoria

Usuario:
* `GET` - Obter lista com 5 usuários com maior quantidade de pontos;
* `GET` - Obter lista de Endereços (CEP, Cidade e Estado) cadastrados no banco de dados;
* `POST` - Cadastrar novos usuários;
* `POST` - Enviar email e senha para verificar se usuário esta cadastrado no banco de dados;
* `PUT` - Atualizar quantidade de pontos do usuário
