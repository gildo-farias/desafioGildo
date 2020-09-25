# Desafio Backend Java
 Desafio de seleção para a empresa GOAT.
 
# API de filmes Externa
 Usei a API do site americano: [OMDb API](http://www.omdbapi.com/)
 - **ATENÇÃO** As buscas devem ser feitas com o titulo do filme em **_inglês_** pois a api usa uma base de dados americana.
 - apikey = **_fa032f7f_**
 
# Base de Dados PostgreSQL
 - Porta = 5432
 - Banco = desafioDB
 - Username = gil
 - Password = 123
 
 # Começando...
  - Crie um usuario:
    - POST LINK: 
     'http://localhost:8080/usuarios/novo'
    - Request Body:
 ```
{
 "login":"user@15",
 "nomeCompleto":"Fulano de Tal",
 "senha":"123"
}
 ```
