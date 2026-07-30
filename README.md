# Sistema de Cadastro de Alunos

Projeto desenvolvido em Java para cadastrar, consultar e excluir alunos, com cadastro de dados no PostgreSQL.

## Funcionalidades

- Cadastro de alunos
- Matrícula gerada pelo PostgreSQL
- Consulta de aluno por matrícula
- Exclusão de aluno por matrícula
- Cálculo de idade a partir da data de nascimento
- Dados mantidos no banco de dados

## Tecnologias utilizadas

- Java
- Maven
- PostgreSQL
- JDBC
- Git e GitHub

## Estrutura do projeto
```text
src/main/java/
├── Aluno.java
├── AlunoDAO.java
├── SistemaAlunos.java
├── Main.java
└── Conexao.java
```

## **Banco de dados**
1.Crie o banco:
```sql
CREATE DATABASE sistema_alunos;
```
2.No banco `sistema_alunos`, crie a tabela:
```sql
CREATE TABLE alunos (
    matricula VARCHAR(20) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    data_nascimento DATE NOT NULL
);
```

## **Como executar**
1. Clone este repositório.
2. Crie o banco e a tabela no PostgreSQL.
3. Crie um arquivo Conexao.java com suas credenciais locais do PostgreSQL.
4. Abra o projeto no **Visual Studio Code**.
5. Execute a classe Main.java.
> **Observação:** o arquivo `Conexao.java` não foi enviado ao repositório para proteger as credenciais do banco.

## **Próximas melhorias**
- Editar dados de um aluno
- Listar todos os alunos
- Validar e-mail e data de nascimento
- Criar interface gráfica ou web
