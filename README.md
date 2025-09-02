# Rock Manager

Sistema de gerenciamento de bandas de rock, shows, participações e usuários, com funcionalidades de importação/exportação e administração.

## Visão Geral
O Rock Manager é uma API RESTful desenvolvida em Java com Spring Boot, focada no gerenciamento de bandas, shows, membros, participações e usuários. O sistema também oferece recursos de autenticação, administração, backup e importação/exportação de dados em múltiplos formatos.

## Endpoints Planejados

### Autenticação
- `POST /login` - Fazer login
- `POST /register` - Registrar usuário

### Usuários
- `GET /users` - Listar usuários
- `PUT /users/{id}` - Atualizar usuário
- `DELETE /users/{id}` - Excluir usuário

### Bandas
- `GET /bands` - Listar bandas
- `GET /bands/{id}` - Obter banda específica
- `POST /bands` - Criar nova banda
- `PUT /bands/{id}` - Atualizar banda
- `DELETE /bands/{id}` - Excluir banda

### Shows
- `GET /shows` - Listar shows
- `GET /shows/{id}` - Obter show específico
- `POST /shows` - Criar novo show
- `PUT /shows/{id}` - Atualizar show
- `DELETE /shows/{id}` - Excluir show

### Participações
- `GET /participacoes` - Listar participações
- `POST /participacoes` - Criar participação
- `PUT /participacoes/{id_banda}/{id_show}` - Atualizar participação
- `DELETE /participacoes/{id_banda}/{id_show}` - Excluir participação

### Membros de Banda
- `GET /bands/members` - Listar membros
- `POST /bands/members` - Adicionar membro
- `PUT /bands/members/{user}/{band}` - Atualizar membro
- `DELETE /bands/members/{user}/{band}` - Remover membro

### Importação/Exportação
- `POST /bands/importar/{formato}` - Importar bandas (CSV/JSON/XML)
- `GET /bands/exportar/{formato}` - Exportar bandas (CSV/JSON/XML)
- `POST /shows/importar/{formato}` - Importar shows
- `GET /shows/exportar/{formato}` - Exportar shows
- `POST /participacoes/importar/{formato}` - Importar participações
- `GET /participacoes/exportar/{formato}` - Exportar participações
- `POST /bands/members/importar/{formato}` - Importar membros
- `GET /bands/members/exportar/{formato}` - Exportar membros

### Administração e Sistema
- `GET /backup` - Exportar backup SQL do banco
- `GET /export-all` - Exportar todos os dados em JSON
- `GET /sys/logs` - Visualizar logs do sistema
- `GET /sys/activity` - Visualizar atividades recentes
- `POST /sys/cleanup` - Limpar dados órfãos e logs antigos

## Tecnologias Utilizadas
- Java 17+
- Spring Boot
- Spring Data JDBC
- Banco de dados relacional (ex: PostgreSQL, MySQL, H2)
- Gradle

## Como Executar

1. Clone o repositório:
   ```bash
   git clone <url-do-repositorio>
   ```
2. Acesse a pasta do projeto:
   ```bash
   cd rock-manager
   ```
3. Configure o banco de dados em `src/main/resources/application.properties`.
4. Execute o projeto:
   ```bash
   ./gradlew bootRun
   ```

## Estrutura do Projeto
- `controller/` - Controllers REST
- `service/` - Lógica de negócio
- `model/` - Entidades do domínio
- `utils/` - Utilitários e helpers

## Contribuição
Pull requests são bem-vindos! Sinta-se à vontade para propor melhorias, correções ou novas funcionalidades.

