# ADR-003 - Wrapped Generation Strategy

Status: Accepted

Date: 2026-06-07

## Context

O principal diferencial do sistema é gerar experiências semelhantes ao Spotify Wrapped.

O processamento tende a crescer conforme aumenta a quantidade de usuários.

## Decision

Separar geração de Wrapped em um módulo dedicado.

Não gerar estatísticas diretamente em Controllers.

Toda geração deve ocorrer através de Use Cases.

## Main Use Cases

GenerateWrappedUseCase

RetrieveWrappedUseCase

RefreshWrappedDataUseCase

## Data Sources

Spotify Top Artists

Spotify Top Tracks

Spotify Recently Played

Spotify User Profile

## Aggregation Strategy

Cada métrica deve possuir responsabilidade isolada.

Exemplos:

HoursListenedCalculator

TopArtistsCalculator

TopTracksCalculator

GenreCalculator

ListeningStreakCalculator

## Wrapped Aggregate

Wrapped

* userId
* period
* generatedAt
* summary

WrappedSummary

* topArtists
* topTracks
* topGenres
* hoursListened

## Scalability Strategy

Hoje:

Spotify API → GenerateWrappedUseCase

Futuro:

Spotify API
↓
Queue
↓
Background Processor
↓
Wrapped Generator
↓
Database

A arquitetura deve permitir migração para processamento assíncrono sem alterar contratos de domínio.

## Persistence

Wrapped gerado poderá ser persistido.

Benefícios:

* evitar chamadas repetidas
* melhorar performance
* histórico anual

## Caching

Preparar suporte para:

Redis

TTL configurável

## Future Features

Comparação anual

Compartilhamento

Wrapped público

Wrapped por período customizado

Wrapped por playlist

Wrapped por artista

## Consequences

Benefícios:

* escalabilidade
* separação de responsabilidades
* processamento desacoplado
* evolução segura

Custos:

* mais componentes
* maior coordenação entre módulos
