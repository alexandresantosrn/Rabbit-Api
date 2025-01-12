# Rabbit-Api
Um pequeno projeto de API utilizando Java e RabbitMQ. 
Projeto baseado na seguinte playlist: https://www.youtube.com/watch?v=BwQMTRh1hCc&list=PL1OeYyl9zqzHDN67rto7KMtezTLmk1N-K.

## Instalação do RabbitMQ via Docker

- Acessar o diretório: ```Rabbit-Docker```.
- Para iniciar a execução do container: ```docker compose up -d```. 
- Para parar a execução do container: ```docker compose down```.

### Acesso ao painel do RabbitMQ
- Após subir aplicação, acessar: ```http://localhost:15672```. 

### Testando o envio de mensagem via Postman
- Criar uma requisição do tipo put para ```localhost:8080/estoque```, com o seguinte corpo: 
```
{
    "productCode": "1A", 
    "quantity": 2   
}
```
- O retorno da requisição será uma resposta com status: ```200 Ok```.
