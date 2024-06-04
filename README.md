# README - Projeto Rainbow
## Sistema de Gerenciamento de uma Biblioteca, com servidor e banco de dados

### Dependências utilizadas
#### App Rainbow
1. JavaFX (Controls, Graphics, FXML)
2. Lombok
3. JSON

#### Server
1. Spring Boot (Data JPA, Starter Web)
2. Flyway
3. Mysql Connector J
4. Lombok

##### - Obs --- Também são utilizadas dependências agregadas evidentemente, isto é, dependências necessárias para usar as dependências principais do projeto

### Informações sobre o Banco de Dados
O banco de dados utilizado para construção do projeto é o MySQL Server
Para utilizá-lo usamos como SO a versão 22.04 do Ubuntu, e a versão 8.0.36 do MySQL

### Configurações necessárias (do banco de dados)
- CREATE DATABASE rainbow;
- CREATE USER 'rainbow'@'localhost' IDENTIFIED WITH mysql_native_password BY 'rainbowR00T*';
- GRANT ALL PRIVILEGES ON rainbow.* TO 'rainbow'@'localhost' WITH GRANT OPTION;