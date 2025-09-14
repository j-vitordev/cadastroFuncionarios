# 📌 Cadastro Email API
## 📖 Sobre o projeto

O Cadastro Email API é uma aplicação desenvolvida em Java + Spring Boot com o objetivo de disponibilizar uma view específica para atualização do campo e-mail no cadastro de funcionários.

A motivação veio de uma necessidade prática: funcionários de RH, muitas vezes, precisam atualizar apenas um campo do cadastro (como o e-mail), mas não podem ter acesso a informações sensíveis como salário ou cargo.

Essa API garante segurança e desacoplamento, permitindo que apenas os dados necessários sejam expostos.



# 🚀 Funcionalidades

✅ Atualização apenas do campo de e-mail de funcionários.

✅ Exposição controlada dos dados via DTO (Data Transfer Object).

✅ Camadas organizadas seguindo boas práticas (Controller, Service, Repository, Model, DTO).

✅ Tratamento centralizado de erros com ExceptionHandler.

✅ Preservação de dados sensíveis que não devem ser expostos ao cliente.




# 🏗️ Arquitetura

Model/Entity (Funcionario) → Representa a tabela no banco de dados.

Chave composta (FuncionarioId) → Gerenciada com @Embeddable.

DTO (FuncionarioModel) → Objeto usado para trafegar dados entre a API e o cliente, sem expor toda a entidade.

Repository → Interface responsável pela comunicação com o banco de dados.

Service → Camada de regras de negócio, responsável por validar e garantir consistência.

Controller → Camada que expõe os endpoints e recebe as requisições REST.

ModelMapperConfig → Classe de configuração responsável por converter automaticamente entre Entity e DTO.

ExceptionHandler → Camada global de tratamento de erros e mensagens personalizadas.




# 📢 Motivação final

Esse projeto mostra como boas práticas de arquitetura em APIs REST ajudam a:

Proteger informações sensíveis.

Facilitar manutenção e escalabilidade.

Entregar ao cliente apenas o que ele precisa.