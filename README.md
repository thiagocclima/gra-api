# gra-api
API RESTful para consulta e manutenção da lista de indicados e vencedores da categoria Pior Filme do Golden Raspberry Awards.
A API foi criada visando atender ao nível de maturidade 2 de Richardson.

## Requisitos
Para execução do projeto, é necessário instalação do JDK 8.

## Para executar o projeto
Para executar o projeto, nenhuma instalação externa é necessária. Ao ser iniciada, a aplicação cria o banco de dados e o popula com os dados do arquivo movielist.csv, que se encontra em *src/main/resources/*.
1. Clone o repositório o faça download;
2. Se está usando uma ferramenta externa a IDE, importe o projeto como projeto Maven existente;
3. Execute o comando Maven abaixo:
```sh
        $ mvn install
```
4. Para iniciar a aplicação clique no projeto com o botão direito do mouse, vá até a opção *Run As* e selecione Spring Boot App.

## EndPoints
Para ver a lista de chamadas REST disponíveis, seus parametros, response HttpStatus code, e tipo de retorno, inicie a aplicação e acesse: http://localhost:8080/api/swagger-ui.html#/

## Bugs
- Há um bug durante o mvn install que impede a execução de um dos testes. É possível executar este teste posteriormente executanto a suite de testes AppTeste.
