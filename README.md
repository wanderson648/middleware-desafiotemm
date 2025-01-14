## Como Rodar o Projeto e Usar o Swagger para Testar a Aplicação

## Requisitos
Antes de começar, certifique-se de que você tem os seguintes requisitos instalados:

- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- Um banco de dados configurado (se necessário pela aplicação, verifique o arquivo `application.yml` para detalhes)

---

## Passos para Rodar o Projeto

1. **Clone o Repositório**

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   ```

2. **Configure o Banco de Dados (se aplicável)**

   Verifique o arquivo `src/main/resources/application.yml` ou `application.properties` para configurar as credenciais e URL do banco de dados. Altere as configurações conforme necessário.

3. **Instale as Dependências**

   No diretório raiz do projeto, execute:

   ```bash
   mvn clean install
   ```

4. **Execute o Projeto**

   Use o seguinte comando para iniciar a aplicação:

   ```bash
   mvn spring-boot:run
   ```

   A aplicação será iniciada em `http://localhost:8083`.

---

## Acessando o Swagger

1. **Acesse o Swagger UI**

   Após iniciar o projeto, abra o navegador e vá para:

   ```
   http://localhost:8082/swagger-ui.html
   http://localhost:8082/swagger-ui/index.html
   ```

2. **Teste os Endpoints**

   - Navegue pelos endpoints disponíveis.
   - Insira os parâmetros necessários nos formulários fornecidos.
   - Clique em **Execute** para enviar as requisições e ver as respostas.

---
