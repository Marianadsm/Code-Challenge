# Code-Challenge
Este projeto é uma API para calcular o preço de ingressos com base em diferentes tipos de ingressos, dias da semana e a disponibilidade de um cartão de estudante. A aplicação foi construída usando o Spring Boot e oferece uma interface RESTful para os usuários.

## Funcionalidades

  - Cálculo do preço do ingresso com base em:
  - Tipo de ingresso (estudante, criança, idoso);
  - Dia da semana;
  - Disponibilidade de cartão de estudante;
 
# API

## Tecnologias Utilizadas

- Java
- Spring Boot
- Maven
- Swagger para documentação da API

## Requisitos
- JDK: 11 ou superior
- Maven: 3.6 ou superior
- Spring Boot: Versão 3.3.4
- IDE

## Instalação
- Clone o repositório
 ```bash
  git clone https://github.com/Marianadsm/Code-Challenge.git -b api
cd Code-Challenge
cd discount-calculation-api
```

- Compile o projeto usando Maven:
 ```bash
  mvn clean install
  ```

- Execute a aplicação:
 ```bash
  mvn spring-boot:run
```

## Endpoints

### Calcular Desconto

- **URL:** `/calculateDiscount`
- **Método:** `GET`
- **Parâmetros:**
  - `type` (string) - Tipo de ingresso (valores: `estudante`, `criança`, `idoso`) **(obrigatório)**
  - `weekDay` (string) - Dia da semana **(obrigatório)**
  - `hasStudentCard` (boolean) - Indica se o usuário possui um cartão de estudante **(obrigatório)**
  
- **Respostas:**
  - `200 OK` - Retorna o preço do ingresso calculado com sucesso.
  - `400 Bad Request` - Retorna um erro se parâmetros inválidos forem fornecidos.

### Exemplo de Requisição
```bash
GET /calculateDiscount?type=estudante&weekDay=segunda&hasStudentCard=true
```
## Documentação

Para visualizar a documentação Swagger, inicie a aplicação. Em seguida, em seu navegador, vá para o domínio: <a href="http://localhost:8080/swagger-ui/index.html"> http://localhost:8080/swagger-ui/index.html </a>

# Front-end

- Node.js >= 18
- npm 
- Angular CLI (versão 12 ou superior)

 # Instalação
- Clone o repositório
 ```bash
git clone https://github.com/Marianadsm/Code-Challenge.git -b front-end
```
- Rode o comando
 ```bash
npm install -g @angular/cli
```
- Instale as dependências com o comando:
 ```bash
npm install
```
- Execute o servidor
```bash
ng serve
```


