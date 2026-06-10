# 🎵 Wrappedfy

Aplicação inspirada no Spotify Wrapped que gera estatísticas personalizadas de consumo musical através da Spotify Web API.

O objetivo é permitir que usuários visualizem seus artistas, músicas e gêneros mais escutados, além de gerar uma experiência compartilhável semelhante ao Spotify Wrapped.

---
<p align="center">
  <img
    width="900"
    alt="Wrappedfy Preview"
    src="https://github.com/user-attachments/assets/d59bdc22-dd40-46e0-b911-6406433915d7"
  />
</p>

---

## 🚀 Tecnologias

### Frontend

- React
- TypeScript
- Vite
- Tailwind CSS
- React Router
- Motion
- Recharts

### Backend

- Java 21
- Spring Boot 3
- PostgreSQL
- Maven
- Spring Security
- JWT

### Integrações

- Spotify Web API
- OAuth 2.0 Authorization Code Flow

---

## 📐 Arquitetura

O projeto segue:

- DDD Pragmático
- Hexagonal Architecture

Estrutura principal:

```text
src/main/java/com/duell/wrappedfy

├── api
├── application
├── domain
└── infrastructure
```

Fluxo de dependências:

```text
Controller
    ↓
Use Case
    ↓
Domain
    ↓
Repository / Gateway
    ↓
Infrastructure
```

### Regras Arquiteturais

- Controllers não possuem regras de negócio
- Use Cases orquestram fluxos
- Domain não depende de Spring
- Infrastructure implementa contratos do domínio

---

## 🔐 Autenticação

O sistema utiliza OAuth 2.0 com Spotify.

Fluxo:

```text
Frontend
    ↓
Spotify Login
    ↓
Authorization Code
    ↓
Backend
    ↓
Spotify Access Token
    ↓
JWT Interno
```

Após autenticação:

- O frontend utiliza apenas JWT próprio
- Tokens Spotify permanecem protegidos no backend

---

## 🎧 Funcionalidades

### MVP

- [x] Login com Spotify
- [x] Recuperação do perfil do usuário
- [ ] Top Artists
- [ ] Top Tracks
- [ ] Top Genres
- [ ] Wrapped Generation

### Futuro

- Histórico anual
- Wrapped público
- Compartilhamento
- Comparação entre anos
- Wrapped por playlist
- Wrapped por artista

---

## 📊 Wrapped Generation

O processamento do Wrapped é desacoplado através de Use Cases dedicados.

Principais componentes:

```text
GenerateWrappedUseCase
RetrieveWrappedUseCase
RefreshWrappedDataUseCase
```

Métricas previstas:

- Top Artists
- Top Tracks
- Top Genres
- Hours Listened
- Listening Streak

---

## 🏗️ ADRs

Documentação arquitetural localizada em:

```text
docs/architecture
```

ADRs atuais:

- ADR-001 - Project Architecture
- ADR-002 - Authentication Strategy
- ADR-003 - Wrapped Generation Strategy

---

## 🛠️ Executando Localmente

### Clonar projeto

```bash
git clone https://github.com/EmanuelGaleno/wrappedfy.git
```

### Entrar na pasta

```bash
cd wrappedfy
```

### Configurar variáveis

Criar arquivo:

```bash
.env
```

Exemplo:

```env
SPOTIFY_CLIENT_ID=
SPOTIFY_CLIENT_SECRET=
JWT_SECRET=
DATABASE_URL=
DATABASE_USERNAME=
DATABASE_PASSWORD=
```

### Subir banco

```bash
docker compose up -d
```

### Executar aplicação

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

---

## 🧪 Testes

Executar:

```bash
./mvnw test
```

---

## 📚 Referências

### Figma

https://www.figma.com/make/4JMtwutYebT4byq4f7PrEF/Wrappedfy-Web-App-Design

### GitHub

https://github.com/EmanuelGaleno/wrappedfy

---

## 👨‍💻 Equipe

Desenvolvido por:

- Emanuel Galeno

Projeto criado para estudo de:

- Java + Spring Boot
- DDD
- Hexagonal Architecture
- OAuth 2.0
- Spotify API
