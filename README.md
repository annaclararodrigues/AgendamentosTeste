# Estudo de Caso - API de Agendamento de Consultas

## Visão Geral da Solução

Esta é uma API RESTful para o agendamento de consultas, desenvolvida como parte de um teste técnico. A aplicação permite criar, listar, cancelar e adicionar notas a agendamentos.

A solução foi construída com Java 17 e Spring Boot 3.3.x, seguindo uma arquitetura em camadas (Entity, Controller, Service, Repository) e utilizando DTOs para a comunicação. Os dados são armazenados em memória (Map) para simplicidade.

## Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3.3.x**
* **Apache Maven**
* **Spring Web:** Para a criação dos endpoints RESTful.
* **Spring Validation:** Para validação dos DTOs de entrada.
* **Lombok:** Para redução de código boilerplate (getters, setters, etc.).

## Execução do Projeto Localmente

### Pré-requisitos

* JDK 17 ou superior
* Apache Maven 3.8+

### Passos

1.  Clone o repositório (substitua `[URL_DO_REPOSITORIO]` pela URL real):
    ```bash
    git clone [URL_DO_REPOSITORIO] AgendamentosTest
    ```

2.  Navegue até o diretório do projeto:
    ```bash
    cd AgendamentosTest
    ```

3.  Compile e execute a aplicação usando o Maven Wrapper:

    * **No Windows:**
        ```bash
        mvnw.cmd spring-boot:run
        ```

    * **No Linux/macOS:**
        ```bash
        ./mvnw spring-boot:run
        ```

4.  A aplicação estará disponível em `http://localhost:8080`.

## Endpoints

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/agendamentos` | Cria um novo agendamento. |
| `GET` | `/agendamentos?status=AGENDADO` | Lista agendamentos filtrando por status. |
| `PUT` | `/agendamentos/{id}/cancelar` | Cancela um agendamento (requer motivo). |
| `POST` | `/agendamentos/{id}/notas` | Adiciona uma nota ao agendamento. |


## Pontos para Futuras Versões

Esta solução é um MVP focado nos requisitos do teste. Para uma versão de produção, os seguintes pontos seriam implementados:

* **Persistência:** Substituir o repositório em memória por um banco de dados real (ex: PostgreSQL) usando Spring Data JPA.
* **Segurança:** Implementar autenticação e autorização (ex: Spring Security com JWT) para proteger os endpoints.
* **Conflitos de Agenda:** Adicionar lógica de negócio no `AgendamentoService` para validar conflitos de horário para o mesmo médico.
* **Reagendamento:** Criar um endpoint `PUT /agendamentos/{id}/reagendar` que valide as novas datas.
* **Testes:** Implementar testes unitários (JUnit/Mockito) para a camada de serviço e testes de integração (Spring Boot Tests/RestAssured) para a camada de controller.
