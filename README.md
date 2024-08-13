<h1 align="center"> API RESTful com Spring Boot</h1>

## 🚀 Tecnologias

- Frontend:
  - [HTML 5](https://www.w3schools.com/howto/howto_make_a_website.asp/)
  - [CSS 3](https://www.w3schools.com/css/css_website_layout.asp/)
  - [JavaScript](https://www.javascript.com/)
  - [Bootstrap 5](https://getbootstrap.com/)
- Backend:
  - [Java 17](http://www.oracle.com/java/technologies/javase-downloads.html)
  - [Apache Maven >=3.8.6](https://maven.apache.org/download.cgi/)
- Database:
  - [MySQL Server](https://dev.mysql.com/downloads/mysql/)
- Ferramenta
  - [Visual Studio Code (VSCode)](https://code.visualstudio.com)
  - [Postman](http://www.postman.com/downloads/)
  - [Git](https://git-scm.com/downloads)
  - [Docker](https://docs.docker.com/desktop/install/windows-install/)

---

## ⤵ Instruções de utilização

Essas instruções vão te levar a uma cópia do projeto rodando em sua máquina local para propósitos de testes, desenvolvimento e aprendizagem.

Pré-requisitos:
  - Java
  - Maven
  - MySQL
  - Docker (Docker-Compose)

<br>

- Passo 1: Clonar o repositório:
  ```bash
  $ git clone https://github.com/ICEI-PUC-Minas-PPLES-TI/PLF-ES-2022-2-MON-CursoAPIJava.git
  ```

<br>

- Passo 2: Configurar e iniciar a API Spring Boot (backend)

  - Passo 2.1: Entrar no arquivo application.properties:
  ```bash
  $ vi PLF-ES-2022-2-MON-CursoAPIJava\src\main\resources\application-dev.properties
  ```

  - Passo 2.2: Configurar as credenciais de banco de dados de acordo com sua instalação do MySQL Server:
  ```proprieties
  # Database config
  spring.datasource.url=jdbc:mysql://localhost:3306/todosimple?createDatabaseIfNotExist=true
  spring.datasource.username=
  spring.datasource.password=
  ```

  - Passo 2.3: Voltar para a pasta raíz do projeto:
  ```bash
  $ cd PLF-ES-2022-2-MON-CursoAPIJava\
  ```

  - Passo 2.4: Iniciar a aplicação Spring Boot:
  ```bash
  $ mvn clean install
  ```
  
    - Passo 2.4.1: Iniciar a aplicação Spring Boot utilizando o Maven:
  ```bash
  $ mvn spring-boot:run
  ```

    ou

    - Passo 2.4.1: Iniciar a aplicação utilizando Docker-Compose:
  ```bash
  $ docker-compose up
  ```

  - API estará rodando em http://localhost:8080/

<br>

- Passo 3: Entrar na aplicação frontend após subir a API

  - Passo 3.1: Entrar na pasta raíz do projeto:
  ```bash
  $ cd PLF-ES-2022-2-MON-CursoAPIJava\
  ```

  - Passo 3.2: Abrir o arquivo index.html diretamente ou pela extensão Live Server do VsCode:
  ```bash
  $ cd PLF-ES-2022-2-MON-CursoAPIJava\view\login.html
  ```

  - Frontend estará rodando em http://127.0.0.1:5500/view/login.html caso iniciado com Live Server.
