# ADR-002 - Authentication Strategy

Status: Accepted

Date: 2026-06-07

## Context

Wrappedfy depende da Spotify Web API.

Toda informação do usuário será obtida através do Spotify.

O sistema não possuirá cadastro próprio inicialmente.

## Decision

Utilizar OAuth 2.0 Authorization Code Flow.

Fluxo:

Frontend
↓
Spotify Authorization
↓
Authorization Code
↓
Backend
↓
Access Token
↓
Spotify API

## Authentication Flow

1. Usuário clica em Login Spotify.

2. Frontend redireciona para Spotify.

3. Spotify autentica usuário.

4. Spotify retorna authorization code.

5. Backend troca code por access token.

6. Backend recupera perfil.

7. Backend cria usuário local.

8. Backend gera JWT interno.

9. Frontend utiliza JWT nas chamadas.

## Internal Authentication

Após autenticação Spotify:

* gerar JWT próprio
* não expor token Spotify ao frontend

Frontend utilizará apenas:

Authorization: Bearer JWT

## Domain Model

User

SpotifyAccount

SpotifyToken

## Gateways

SpotifyAuthGateway

SpotifyProfileGateway

## Security

Spring Security

JWT Authentication Filter

Role-based preparado para expansão futura.

## Future Evolution

Preparado para:

* Google Login
* Apple Login
* Conta local
* Multi Provider Authentication

Sem necessidade de alteração na camada de domínio.
