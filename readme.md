# Sales Management System (JavaFX + JDBC)

Sistema de gerenciamento de vendas desenvolvido para consolidar conhecimentos em Java, interface gráfica com JavaFX e persistência de dados em bancos relacionais utilizando JDBC.

## 🚀 Tecnologias e Conceitos

* **Linguagem:** Java 25
* **UI:** JavaFX (FXML + Scene Builder)
* **Banco de Dados:** PostgreSQL / MySQL
* **Padrão de Arquitetura:** DAO (Data Access Object)
* **Padrões de Projeto:** Observer (DataChangeListener) e Injeção de Dependência
* **Tratamento de Dados:** Validações personalizadas e tratamento de exceções de integridade

## 🛠️ Funcionalidades

### Gestão de Vendedores (Sellers)
* Cadastro completo com validação de campos obrigatórios.
* Formatação automática de datas (`dd/MM/yyyy`) e valores monetários.
* Seleção de departamento via ComboBox dinâmico.
* Edição e remoção com confirmação de segurança.

### Gestão de Departamentos (Departments)
* Listagem e gerenciamento de setores da empresa.
* Garantia de integridade referencial (bloqueio de exclusão de departamentos com vendedores ativos).

## 🏗️ Estrutura das Camadas

* **`gui`**: Controllers e utilitários da interface.
* **`model.entities`**: Classes de modelo (POJOs).
* **`model.services`**: Regras de negócio e intermediação.
* **`model.dao`**: Interfaces e implementações para persistência.
* **`db`**: Gestão da conexão com o banco de dados.

## 📋 Configuração do Ambiente

1. Certifique-se de ter o **Java JDK 25** e o **JavaFX SDK** configurados.
2. Importe o driver JDBC correspondente ao seu banco no `build path`.
3. Configure o arquivo `db.properties` na raiz do projeto:
   ```properties
   user=seu_usuario
   password=sua_senha
   dburl=jdbc:postgresql://localhost:5432/nomedobanco

✒️ Autor

* Paulo Fernando Maggio * LinkedIn: www.linkedin.com/in/paulo-maggio-1738491a7
