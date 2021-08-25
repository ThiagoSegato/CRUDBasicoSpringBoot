## CRUD básico com Spring Boot [![ThiagoSegato](https://circleci.com/gh/ThiagoSegato/CRUDBasicoSpringBoot.svg?style=shield)]
Utilizado o banco de dados H2 para maior facilidade na instalação do projeto, juntamente com o controle de versionamento Flyway. Especificação OpenAPI gerada através da biblioteca SpringFox com ferramenta SwaggerUI.

### Desenvolvimento / Testes de Integração e de API
Em desenvolvimento o banco de dados é utilizado na forma de arquivo (file:~/crudbasico) criando-o na primeira execução do projeto somente com a estrutura. Já em ambiente de testes é criado na forma de memória (mem:test) com a execução da estrutura e o povoamento através do arquivo afterMigrate.sql.

### Modelo entidade relacionamento
Foi utilizado um modelo de contrato musical voltado para bandas de rock. Caso seja cadastrada uma banda de sertanejo será lançada uma exceção IllegalArgumentException :)

### Links úteis 
Arquivo de especificação OpenAPI - http://localhost:8080/v2/api-docs<br>
Ferramenta interação do Swagger - http://localhost:8080/swagger-ui/index.html<br>
Console banco de dados H2 -  http://localhost:8080/h2-console/<br>

### IDE Utilizada
Para desenvolvimento deste projeto foi utilizada a IDE Spring Tools 4 for Eclipse (https://spring.io/tools) com a ferramenta Spring Initalizr (https://start.spring.io/) com a versão do Spring 2.5.4, estável, gerado em 23/08/2021.

### Melhorias
- [ ] Implementar HATEOAS no projeto para melhorar a comunicação com sistemas que utilizam essa arquitetura;
