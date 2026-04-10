# SpringCommerce API

Este é um projeto **API RESTful de E-commerce** simplificado desenvolvido em **Java** utilizando o framework **Spring Boot**. O objetivo principal do sistema é gerenciar operações de comércio eletrônico, como usuários, categorias, produtos, pedidos e pagamentos, explorando boas práticas de desenvolvimento web e persistência de dados.

## 🚀 Tecnologias Utilizadas

O projeto foi construído com as seguintes tecnologias e dependências:

*   **Java 17**: Linguagem de programação.
*   **Spring Boot (3.2.5)**: Framework principal para facilitar a configuração e publicação da aplicação.
*   **Spring Web**: Para a construção de APIs RESTful.
*   **Spring Data JPA**: Para a persistência de dados utilizando a API de Persistência do Java (Hibernate sob os panos).
*   **H2 Database**: Banco de dados em memória, excelente para desenvolvimento, testes e prototipagem rápida.
*   **Maven**: Gerenciador de dependências e build do projeto.

## ⚙️ Como Executar o Projeto

Para rodar este projeto localmente, siga os passos abaixo. É necessário ter o **Java 17** e o **Maven** instalados em sua máquina.

1.  **Clone o repositório** (se aplicável):
    ```bash
    git clone <url-do-repositorio>
    ```

2.  **Acesse a pasta do projeto**:
    ```bash
    cd curso
    ```

3.  **Execute a aplicação usando o Maven**:
    ```bash
    mvn spring-boot:run
    ```

4.  **Acesso à Aplicação**:
    Por padrão, a aplicação estará rodando em `http://localhost:8080`.
    
    Caso o console do banco H2 esteja habilitado (normalmente acessível via `http://localhost:8080/h2-console`), você poderá visualizar o banco de dados em memória durante a execução do projeto.

## 📁 Estrutura do Projeto

O projeto segue a estrutura padrão do Maven para aplicações Spring Boot:

*   `src/main/java`: Contém todo o código-fonte da aplicação (Controladores, Serviços, Modelos, Repositórios, etc).
*   `src/main/resources`: Contém arquivos de propriedades (como o `application.properties`) e recursos estáticos.
*   `pom.xml`: Arquivo de configuração do Maven contendo todas as dependências do projeto.
