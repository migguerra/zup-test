# Awesome README [![Awesome]
Desafio criado pela Zup Bootcamp é construir a API que serve para Youtube, LinkedIn ou Instagram 
Optei pela construção de um modelo de API semelhante a Youtube. A qual vai conter crud de usuario e videos alem de comentarios de videos.

### Prerequisites

O projeto foi desenvolvido em Java 11 usando Springboot.

A escolha do Springboot como starter ocorre para facilitar a configuração do projeto o qual foi dividido em modulos. 
O processo foi desenvolvido seguindo os principios de SOLID, 


```
Web - Full-Stack para desenvolvimento do spring.
JPA - Para a persistencia dos dados incluindo spring-data e hibernate.
H2 -Banco de dados em memoria.
Swagger2 - Para criação do swagger para documentação dos endpoints.
```

###Usage

para utilizar a aplicação basta executar sua classe main e consultar sua documentação disponivel em:

```
localhost:8080/youtube/swagger-ui.html
```

a primeira e principal rota e a de usuario que foi definida como:

```
localhost:8080/youtube/user
```
nela e possivel cadastrar,editar,buscar e deletar usuarios.

Exemplo do json de usuario:

```javascript
{
  "email": "string",
  "id": 0,
  "profile": {
    "address": "string",
    "name": "string",
    "nick": "string"
  },
  "senha": "string"
}
```
<br>

a rota de referente a video foi definida em:

```
localhost:8080/youtube/video
```
nela e possivel cadastrar,editar,buscar e deletar video o video tem q ser vinculado a um usuario pelo seu id.

Exemplo do json de usuario:

```javascript
{
  "deslikeVideo": 0,
  "duration": "string",
  "id": 0,
  "likeVideo": 0,
  "name": "string",
  "url": "string",
  "view": 0
}
```
<br>

a rota de referente a video foi definida em:

```
localhost:8080/youtube/coments
```
nela e possivel cadastrar,editar,buscar e deletar comentarios, o comentario tem que ser associado a um usuario e a um video atraves de seus id's.

Exemplo do json de usuario:

```javascript
{
  "id": 0,
  "coment": "string"
}
```
<br>