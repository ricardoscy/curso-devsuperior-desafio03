## DESAFIO: CRUD de clientes

Projeto Spring Boot contendo um CRUD completo de web services REST para
acessar um recurso de clientes, contendo as cinco operações básicas:
- Busca paginada de recursos
- Busca de recurso por id
- Inserir novo recurso
- Atualizar recurso
- Deletar recurso

---
Ferramentas:
Spring Web | Spring MVC | Spring JPA | Spring Validation | H2 | Maven | Design Patterns
---
### Testes manuais no Postman

#### Busca de cliente por id:
GET /clients/1

#### Busca paginada de clientes:
GET /clients?page=0&size=6&sort=name

#### Inserção de novo cliente
POST /clients

``{
"name": "Maria Silva",
"cpf": "12345678901",
"income": 6500.0,
"birthDate": "1994-07-20",
"children": 2
}
``

#### Atualização de cliente
PUT /clients/1

``{
"name": "Maria Silvaaa",
"cpf": "12345678901",
"income": 6500.0,
"birthDate": "1994-07-20",
"children": 2
}
``

#### Deleção de cliente
DELETE /clients/1