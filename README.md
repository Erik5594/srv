# srv

No cooperativismo, cada associado possui um voto e as decisões são tomadas em assembleias, por votação.
Esta solução gerencia sessões de votação de uma determinada pauta.

## Começando

Para executar o projeto, será necessário instalar os seguintes programas:

- [JDK 8: Necessário para executar o projeto Java](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- [Gradle 6.8.2: Necessário para realizar o build do projeto Java](https://gradle.org/next-steps/?version=6.8.2&format=bin)
- [Eclipse: Para desenvolvimento do projeto](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/oxygen3a) ou a IDE de sua preferência
- [Criar um banco de dados MongoDB](https://www.mongodb.com/pt-br) aqui é possível criar instâncias de banco para utilização.

## Tecnologias Utilizadas

- [Spring Boot v5 Reativo](https://spring.io/reactive)
- [Spring Data Reactive para MongoDB](https://spring.io/projects/spring-data-mongodb)
- [Spring Boot WebFlux](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html)
- [Java 8](https://www.java.com/pt-BR/download/help/java8_pt-br.html)

## Features

Tratasse de uma API REST com serviços voltados para gerenciamento de Pautas de Assembleias.

## Configuração

Necessário criar uma instância no [MongoDB](https://www.mongodb.com/pt-br).

Para conseguir executar o projeto, será necessário configurar o arquivo *api-vr/src/main/resources/application.properties*, alterando as configurações de acesso ao Banco de Dados, para a nova instância criada.
