# Aplicação de Geração de Pedidos

Esta aplicação Java é projetada para gerenciar a geração de pedidos, utilizando MongoDB para armazenamento de dados e RabbitMQ para facilitar as transações através de filas de mensageria.

## Requisitos

- Java 11+
- MongoDB 4.0+
- RabbitMQ 3.8+

## Estrutura do Projeto

- **src/main/java**: Contém o código fonte da aplicação.
- **src/main/resources**: Contém os arquivos de configuração.
- **pom.xml**: Arquivo de configuração do Maven.

## Configuração

### MongoDB

Certifique-se de que o MongoDB está instalado e em execução na sua máquina. Por padrão, a aplicação se conecta ao MongoDB na URL `mongodb://localhost:27017`.

### RabbitMQ

Certifique-se de que o RabbitMQ está instalado e em execução na sua máquina. Por padrão, a aplicação se conecta ao RabbitMQ na URL `amqp://localhost`.

### Arquivo de Configuração

O arquivo `application.properties` deve ser configurado com as seguintes propriedades:

```properties
# MongoDB
spring.data.mongodb.uri=mongodb://localhost:27017/seu_database

# RabbitMQ
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=admin
spring.rabbitmq.password=admin

pom.xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
