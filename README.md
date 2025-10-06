# 🩺 Sistema de Agendamento Médico - Spring Boot

---

## Visão do Projeto
Este projeto implementa um **sistema de agendamento de consultas médicas** utilizando o framework **Spring Boot**, seguindo boas práticas de arquitetura e separação de camadas (Controller, Service, Repository, Loader, DTO e Mapper).  
O sistema integra duas APIs públicas para validações externas: **ViaCep** (pa****ra consulta de endereços) e **BrasilAPI** (para verificação de feriados nacionais).

---

## Funcionalidades e Endpoints

- CRUD de Agendamento de consulta associada a um medico e um paciente
  - `GET /api/agendamentos`
  - `GET /api/agendamentos/{id}`
  - `GET /api/agendamentos/verificarAgendamento`
  - `POST /api/agendamentos`
  - `PUT /api/agendamentos/{id}`
  - `DELETE /api/agendamentos/{id}`
- CRUD de Médico
  - `GET /api/medicos`
  - `GET /api/medicos/{id}`
  - `GET /api/medicos/agenda`
  - `POST /api/medicos`
  - `PUT /api/medicos/{id}`
  - `DELETE /api/medicos/{id}`
- CRUD de Paciente
  - `GET /api/pacientes`
  - `GET /api/pacientes/{id}`
  - `GET /api/pacientes/consultas`
  - `POST /api/pacientes`
  - `PUT /api/pacientes/{id}`
  - `DELETE /api/pacientes/{id}`
- Carregamento automático do Endereço atrvés do CEP, consumindo a API [ViaCep](https://viacep.com.br/)
  - `GET /api/endereco/{cep}`
- Validação de agendamento em feriados, consumindo a informação através da [BrasilAPI](https://brasilapi.com.br/).
  - Obs: endpoint usado apenas de maneira interna, sem necessidade de expor na aplicaçao

---

## Arquitetura

- **`common-domain`:** Concentra as entidades de domínio Agendamento, Endereço, Médico, Paciente, Pessoa e TipoConsulta
- **`external-api`:** Módulo responsável pela comunicaçao das APIs externas. Usa o Feign Client para trazes as informações das APIS ViaCep e BrasilAPI para o contexto de multi módulos.
- **`main-app`:** Concentra toda a lógica de negócio, define dados de entrada e saída através de DTOs, garante a segurança atraves do Spring Security e expoe a API Rest

---

## Segurança

A autorizacao da aplicaçao é baseada em roles:
- **Admin**: username: `admin`, password: `adminPass`, role: `ADMIN`
- **User**: username: `user`, password: `userPass`, role: `USER`

O acesso é dado através de cada endpoint e está constrído da seguinte forma:

**Acesso do ADMIN (POST, PUT, DELETE):**
- `/agendamentos/**` - Gestao de agendamentos
- `/medicos/**` - Gestao de medicos
- `/paciente/**` - Gestao de pacientes

**Acesso ADMIN e USER (GET):**
- `/api/agendamentos, /api/agendamentos/*` - Consulta de agendamentos
- `/api/medicios, /api/medicos/*` - Consulta de médicos
- `/api/pacientes, /api/pacientes/*` - Consulta de pacientes

**Acesso Liberado (Permit All)**
- `/h2-console` - Console do banco de dados

Por padrao, qualquer endpoint diferente dos citados acima terá seu acesso negado.