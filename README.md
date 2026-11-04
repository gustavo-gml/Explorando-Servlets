# Explorando o Protocolo HTTP com Java Servlets

Atividade da disciplina **Tecnologias de Desenvolvimento para Internet III**, do IFSULDEMINAS – Campus Machado (professor Dr. Emerson A. Carvalho).

**Aluno:** Gustavo Martins de Lima

O projeto reúne cinco Servlets que servem para observar, na prática, como o HTTP funciona: métodos (GET, POST, OPTIONS), cabeçalhos de requisição e resposta, corpo da requisição, cookies/sessão e códigos de status.

## Tecnologias

- Java Servlets (`jakarta.servlet`)
- Apache Tomcat 10 ou superior (as versões anteriores usam `javax.servlet` e não são compatíveis com este código)
- Eclipse (Dynamic Web Project)

## Estrutura do projeto

```
Explorando-Servlets
├── src/main/java/controller
│   ├── HeadersServlet.java
│   ├── RequestBodyServlet.java
│   ├── SessionServlet.java
│   ├── StatusServlet.java
│   └── MethodsServlet.java
└── src/main/webapp
    ├── index.html      (página com links para testar os servlets)
    └── form.jsp        (formulário usado pelo /request-body)
```

> Os caminhos acima seguem o padrão do Eclipse. Se o seu projeto usa `Java Resources/src` e `WebContent`, a organização é equivalente.

## Como executar

1. Clone o repositório e importe no Eclipse (*File > Import > Existing Projects into Workspace*).
2. Configure um servidor **Apache Tomcat 10+** na aba *Servers*.
3. Clique com o botão direito no projeto e escolha *Run As > Run on Server*.
4. Acesse a página inicial: `http://localhost:8080/Explorando-Servlets/`

A porta (`8080`) e o nome do contexto (`Explorando-Servlets`) podem mudar conforme a configuração do seu Tomcat. Os exemplos abaixo usam esses valores.

## Endpoints

| Servlet | Método | URL | O que faz |
| --- | --- | --- | --- |
| `HeadersServlet` | GET | `/headers` | Exibe os cabeçalhos da requisição, o IP do cliente e a versão do protocolo HTTP |
| `RequestBodyServlet` | POST | `/request-body` | Recebe o formulário (nome, e-mail e mensagem) e exibe os dados enviados |
| `SessionServlet` | GET | `/session` | Controle de login e boas-vindas ao usuário |
| `StatusServlet` | GET | `/status?code=404` | Responde com o código de status informado no parâmetro `code` |
| `MethodsServlet` | OPTIONS | `/methods` | Informa os métodos suportados pelo servidor (cabeçalho `Allow`) |

## Como testar

### 1. `/headers`

Pelo navegador, clique em **Headers** na página inicial. Como o acesso vem de um link, o cabeçalho `Referer` aparece na lista. Acessando a URL direto na barra de endereço, ele não é enviado.

Pelo terminal:

```bash
curl -i http://localhost:8080/Explorando-Servlets/headers
```

Rodando em `localhost`, o IP pode aparecer como `0:0:0:0:0:0:0:1`, que é o endereço local em IPv6.

### 2. `/request-body`

Pelo navegador, clique em **RequestBody**, preencha o formulário e envie.

Pelo terminal:

```bash
curl -i -X POST \ -d "nome=Maria&email=maria@exemplo.com&msn=Ola" \ http://localhost:8080/Explorando-Servlets/request-body
```

### 3. `/session`

Pelo navegador:

1. Clique em **Realizar Login**.
2. Clique em **Entrar** e veja a mensagem de boas-vindas.
3. Para comparar, teste o **Entrar** em um navegador novo (ou aba anônima), sem ter feito login.

Pelo terminal, guardando e reenviando os cookies:

```bash
curl -i -c cookies.txt "http://localhost:8080/Explorando-Servlets/session?status=Autorizado"
curl -i -b cookies.txt http://localhost:8080/Explorando-Servlets/session
```

### 4. `/status`

O código de status é escolhido pelo parâmetro `code` da URL.

| URL | Resultado esperado |
| --- | --- |
| `/status?code=200` | 200 OK |
| `/status?code=201` | 201 Created |
| `/status?code=404` | 404 Not Found |
| `/status?code=500` | 500 Internal Server Error |

```bash
curl -i "http://localhost:8080/Explorando-Servlets/status?code=404"
```

No navegador, repare em como cada código é exibido. A aba *Network* do F12 mostra o status de cada resposta.

### 5. `/methods`

O navegador só envia GET e POST por links e formulários, então o OPTIONS precisa ser enviado de outra forma.

**Pela página inicial:** o link **Methods** faz uma requisição `OPTIONS` com `fetch` e mostra o resultado na tela.

**Pelo terminal:**

```bash
curl -i -X OPTIONS http://localhost:8080/Explorando-Servlets/methods
```

Exemplo de resposta:

```
HTTP/1.1 200
Allow: GET, POST, OPTIONS
```

**Pelo console do navegador (F12):**

```js
fetch('methods', {method: 'OPTIONS'}).then(r => console.log(r.headers.get('Allow')))
```

## Conceitos de HTTP explorados

| Conceito | Onde aparece |
| --- | --- |
| Métodos GET, POST e OPTIONS | Todos os servlets (`doGet`, `doPost`, `doOptions`) |
| Cabeçalhos de requisição (`User-Agent`, `Referer`, `Accept-Language`, `Accept-Encoding`, `Host`) | `/headers` |
| Cabeçalho de resposta `Allow` | `/methods` |
| Corpo da requisição | `/request-body` |
| Cookies | `/session` |
| Códigos de status (200, 201, 404, 500) | `/status` |
