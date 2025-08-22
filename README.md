# Documentação Projeto mBank

## Pre-requisitos

**Ter o docker instalado em seu computador**  
Para mais informações sobre o docker ou docker-compose acesse:

https://docs.docker.com/get-started/

**Ter o git instalado em seu computador**  
Para mais informações sobre como instalar e utilizar o git acesse:

https://git-scm.com/book/pt-br/v2/Come%C3%A7ando-Instalando-o-Git

## Inicializando o projeto

Abra uma instância de um terminal dentro do diretório raiz do projeto.

Execute os seguintes comandos

```
chmod +x build.sh
```

Após dar permissão em seu SO, execute

```
./build.sh
```

Isso irá inicializar os container dockers necessários, acompanhe o status das apis no console, após terminar o processo de build e deploy as apis estarão disponíveis em:

```
API-1: localhost:8081
```

```
API-2: localhost:8082
```

## Banco de Dados

Após subir o banco ao executar o script build.sh, o banco fica acessível em:

```
username = mbank
password = mbank
url = jdbc:postgresql://localhost:5442/mbankdb
```

## RabbitMQ

Após subir o rabbitMQ ao executar o script build.sh, fica acessível em:

```
host = localhost
port = 5672
username = admin
password = password
```

## Controle de acesso e autenticação

A aplicação está configurada com Basic Auth e os endpoints necessitam de autenticação por usuário e senha, segue as credenciais de acesso:

```
username = admin
password = 1234
```

## Após subir

Você pode testar o funcionamento das apis em

```
localhost:8081/status
```
e
```
localhost:8082/status
```

## Primeira Carga

Após subir, você pode chamar a carga inicial no endpoint

```
localhost:8081/marcas/carga-inicial
```

**ATENÇÃO: MESMO QUE API RETORNE DADOS, ISSO IRÁ POPULAR O BANCO COM VÁRIOS REGISTROS E PODE DEMORAR ALGUNS MINUTOS**

Acompanhe no log da aplicação o fim da carga inicial.


## Documentação

A documentação dos end-points fica acessível em:

```
localhost:8081/docs
```
