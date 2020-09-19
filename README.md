# Desafio Backend Java
 Desafio de seleção para a empresa GOAT.
 
# API de filmes Externa
 Usei a API do site americano: [OMDb API](http://www.omdbapi.com/)
 - **ATENÇÃO** As buscas devem ser feitas com o titulo do filme em **_inglês_** pois a api usa uma base de dados americana**
 - apikey = **_fa032f7f_**
 
# Base de Dados PostgreSQL
  > Usuario sendo validado na base de dados com Spring Security.
  
 - Spring Security Acesso.
   Username = **gil@15**
   Password = **123**
  ```
  INSERT INTO usuario(login, nome_completo, senha) VALUES ('gil@15','Gildo Farias','$2a$10$h/AryOozC6DSEkMvGtEO..ULp2S8TpgT.J7Yrq7A9Gh9WHPrsPBgG')
  ```
 - Porta = 5432
 - Banco = desafioDB
 - Username = postgres
 - Password = 123456
