<h1 align="center">
  TODO List
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Estudo&color=00ff7f&labelColor=000000" alt="Estudo" />
</p>

API simples para gerenciar tarefas (CRUD), feita somente para estudos


## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Docker](https://www.docker.com/products/docker-desktop/)
- [PostgreSQL]([https://dev.mysql.com/downloads/](https://www.postgresql.org/download/))

## Práticas adotadas

- SOLID, DRY
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro

## Instalação e Configuração
- Clonando o repositório:
```
git clone https://github.com/FelpFS1/simple-todolist.git
cd simple-todolist
```

## Subindo o Banco de Dados com Docker
- Se ainda não possui o Docker instalado, baixe e instale pelo site oficial:
[Docker Download](https://www.docker.com/products/docker-desktop/)
- Para iniciar o banco de dados PostgreSQL, execute:
```
docker-compose up -d
```
- Caso prefira rodar o banco sem docker-compose, crie um container manualmente:
```
docker run --name postgres-todolist -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=senha123 -e POSTGRES_DB=meu_postgres -p 5432:5432 -d postgres

```
## Configuração do Banco de Dados
 - Por padrão, a aplicação espera a seguinte configuração no PostgreSQL:
```
Host: localhost
Porta: 5432
Database: meu_postgres
Usuário: postgres
Senha: senha123
```
 - Caso precise alterar, modifique o arquivo ```src/main/resources/application.properties.```

## Execução
- Gerando e executando o JAR
  ```
  mvnw clean package -DskipTests
  java -jar target/simple-todolist-0.0.1-SNAPSHOT.jar
  ```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io):

- Criar Tarefa 
```
$ http POST :8080/todos  description="Desc Todo 1" priority=1

[
  {
    "description": "Desc Todo 1",
    "id": 1,
    "priority": 1,
    "completed": false
  }
]
```

- Listar Tarefas
```
$ http GET :8080/todos

[
  {
    "description": "Desc Todo 1",
    "id": 1,
    "priority": 1,
    "completed": false
  }
]
```

- Atualizar Tarefa
```
$ http PUT :8080/todos/1  description="Desc Todo 1 Up" priority=2

[
  {
    "description": "Desc Todo 1 Up",
    "id": 1,
    "priority": 2,
    "completed": false
  }
]
```

- Remover Tarefa
```
http DELETE :8080/todos/1

[ ]
```
