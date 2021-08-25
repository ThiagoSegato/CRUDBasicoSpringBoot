### CRUD básico com Spring Boot  ![ThiagoSegato](https://circleci.com/gh/ThiagoSegato/CRUDBasicoSpringBoot.svg?style=shield)
<div align="justify">Utilizado o banco de dados H2 para maior facilidade na instalação do projeto, juntamente com o controle de versionamento Flyway. Especificação OpenAPI gerada através da biblioteca SpringFox com ferramenta SwaggerUI.</div>

#### Modelo entidades e controller
<div align="justify">Foi utilizado um modelo de contrato musical voltado para bandas de rock. Caso seja cadastrada uma banda de sertanejo será lançada uma exceção GeneroInvalidoException :)</div>

![ThiagoSegato](https://user-images.githubusercontent.com/26276218/130708695-bed7ed55-5687-499e-a64b-d0635d6ea8ce.png)

#### Desenvolvimento / Testes de Integração e de API
<div align="justify">Em desenvolvimento o banco de dados é utilizado na forma de arquivo (file:~/crudbasico) criando-o na primeira execução do projeto. Através do primeiro versionamento é criada a estrutura e no segundo, o povoamento do banco de dados. Já em ambiente de testes é utilizado na forma de memória (mem:test).</div>

#### Links úteis 
Arquivo de especificação OpenAPI - http://localhost:8080/v2/api-docs<br>
Ferramenta interação do Swagger - http://localhost:8080/swagger-ui/index.html<br>
Console banco de dados H2 -  http://localhost:8080/h2-console/<br>

#### IDE utilizada
<div align="justify">Para desenvolvimento deste projeto foi utilizada a IDE Spring Tools 4 for Eclipse (https://spring.io/tools) com a ferramenta Spring Initalizr (https://start.spring.io/) com a versão do Spring 2.5.4, estável, gerado em 23/08/2021.</div>

#### Melhorias
- [ ] Implementar HATEOAS no projeto para melhorar a comunicação com sistemas que utilizam essa arquitetura;
- [ ] Implementar Spring Security para autenticação e autorização dos recursos;
