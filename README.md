# Star Wars Resistence Social Network API

## Documentação
Os *endpoints* da API foram documentados utilizando  [Swagger](https://swagger.io/), e após executar o projeto com o comando `./mvnw spring-booot:run` no diretório raiz, ela estará disponível no seguinte endereço: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)


## Tecnologias utilizadas

- [Java 8](https://www.java.com/pt_BR/download/faq/java8.xml);
- [Spring Boot 2.3.1](https://spring.io/projects/spring-boot);
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa);
- [Hibernate](https://hibernate.org/) com banco de dados [H2](https://www.h2database.com/html/main.html);
- Gerenciador de dependência [Maven](https://maven.apache.org/);
- Versionador de banco de dados [Flyway](https://flywaydb.org/)


## Decisões tomadas
- Arquitetura MVC com acesso a dados com padrão Data Access Object - **DAO**;
- Caso um traidor tente denunciar outro rebelde, obterá acesso probido (403 Forbidden);

- Os campos total de denúncias e o status para delimitar se um rebelde é traidor (isRenegade), estão estão definidos como apenas de leitura e são inicializados automaticamente;

## Problemas encontrados
- Inicialmente tentei implementar relacionamentos um para um (@OneToOne) da entidade do rebelde com localização, inventário e denúncia. Todavia, acabei obtendo alguns problemas de chave estrangeira e devido ao tempo restante ser reduzido, optei por "embutir" as classes relacionadas aos rebeldes utilizando a annotation @Embeddable;

- Perdi muito tempo tentando achar um erro referente a diferenças entre atributos da tabela comparados a resposta da requisição. Depois descobri que a inconsistência tratava-se da serialização dos objetos da classe;

- Em relação aos relatórios, a porcentagem de traidores e rebeldes acabavam sendo zeradas após um rebelde tornar-se um traidor, e como não consegui resolver a tempo, deixei o trecho comentado no fim do controlador dos relatórios;

## Pendências
- Negociação de itens;
- Relatório da porcentagem de traidores e rebeldes e o total de pontos perdidos devido a traidores;
- Testes unitários e / ou integração