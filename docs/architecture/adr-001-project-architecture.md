# ADR-001 - Project Architecture

Status: Accepted

Date: 2026-06-07

## Context

Wrappedfy é uma aplicação inspirada no Spotify Wrapped.

O sistema consumirá dados da Spotify Web API para gerar estatísticas personalizadas e experiências de visualização para o usuário.

O projeto deverá ser escalável, testável e preparado para crescimento futuro.

Funcionalidades previstas:

* OAuth Spotify
* Perfil do usuário
* Top artistas
* Top músicas
* Top gêneros
* Wrapped anual
* Histórico de execuções
* Compartilhamento de resultados

## Decision

Adotar arquitetura DDD Pragmática com Hexagonal Architecture.

Estrutura principal:

api
application
domain
infrastructure

Fluxo:

Controller
↓
UseCase
↓
Domain
↓
Gateway / Repository
↓
Infrastructure

## Layer Responsibilities

### API

Responsável por:

* Controllers
* Request DTOs
* Response DTOs
* Validation

Não deve conter regra de negócio.

### Application

Responsável por:

* Use Cases
* Orquestração de fluxos
* Coordenação de integrações

Exemplos:

AuthenticateSpotifyUseCase

RetrieveTopArtistsUseCase

GenerateWrappedUseCase

### Domain

Responsável por:

* Entidades
* Value Objects
* Contratos
* Regras de negócio

Não deve depender de Spring.

Não utilizar:

@Service

@Repository

@Component

na camada de domínio.

### Infrastructure

Responsável por:

* JPA
* PostgreSQL
* Spotify API
* OAuth
* Security
* Cache

Implementa contratos definidos pelo domínio.

## Package Structure

com.duell.wrappedfy

api

application

domain

infrastructure

## Repository Strategy

Interfaces:

domain.repository

Implementações:

infrastructure.persistence

Exemplo:

domain.repository.UserRepository

infrastructure.persistence.JpaUserRepository

## Dependency Rule

Permitido:

api → application

application → domain

infrastructure → domain

Não permitido:

domain → application

domain → infrastructure

application → api

## Testing Strategy

Prioridade:

1. Unit Tests
2. Integration Tests

Todo UseCase deve ser testável sem banco real.

## Consequences

Benefícios:

* Baixo acoplamento
* Alta coesão
* Facilidade de testes
* Evolução controlada
* Integrações desacopladas

Custos:

* Mais classes
* Maior disciplina arquitetural
