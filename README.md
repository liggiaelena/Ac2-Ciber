# Ac2-Ciber

## Questão 1: Desenvolvimento de Aplicação Web

A aplicação desenvolvida permite a troca segura de mensagens entre dois usuários, utilizando **criptografia simétrica (AES)** e proteção contra **ataques CSRF**.

### 1. Criptografia de Mensagens (AES)

A criptografia simétrica foi implementada usando o algoritmo AES (Advanced Encryption Standard), no qual a mesma chave é usada para criptografar e descriptografar mensagens.

#### Funcionamento:
- O usuário digita a mensagem no front-end.
- A mensagem é criptografada no back-end usando uma chave AES.
- A mensagem criptografada é armazenada ou transmitida.
- Ao receber, a mesma chave é usada para descriptografar e exibir a mensagem original.

#### Justificativa da escolha:
O AES é rápido, eficiente e seguro, sendo ideal para proteger o conteúdo das mensagens em um ambiente controlado onde a chave pode ser mantida de forma segura.

---

### 2. Mitigação de CSRF

Para proteger a aplicação contra ataques CSRF (Cross-site Request Forgery), foi implementado o uso de **tokens CSRF**.

#### Estratégia:
- Um token CSRF é gerado no backend e enviado ao cliente.
- O token é armazenado em um campo oculto do formulário.
- Toda requisição POST inclui esse token.
- O servidor valida o token antes de processar a ação.

#### Justificativa da escolha:
O uso de tokens é uma das práticas mais eficazes para mitigar CSRF, pois garante que a requisição veio de uma origem confiável.

---

### 3. Interface Front-End

A interface foi criada de forma simples e funcional:

- Um **campo de texto** para digitar a mensagem.
- Um **botão** para envio.
- Uma **área de exibição** para as mensagens recebidas.

As interações são feitas por meio de requisições HTTP protegidas com o token CSRF, e todas as mensagens trafegam criptografadas.

---

### 4. Testes e Validação

- A criptografia foi validada interceptando a mensagem criptografada e tentando decodificá-la sem a chave — não foi possível.
- A proteção CSRF foi testada simulando uma requisição maliciosa sem o token, que foi corretamente rejeitada pela aplicação.

---

### Tecnologias utilizadas

- **Linguagem**: Java
- **Criptografia**: AES (128 bits)
- **Segurança**: token CSRF gerado e validado no backend
- **Front-End**: HTML e JavaScript básico para envio/exibição das mensagens
## Questão 2: Teoria de Criptografia

A criptografia é uma técnica essencial para proteger dados, tornando-os ilegíveis para pessoas não autorizadas. Existem dois tipos principais: criptografia simétrica e criptografia assimétrica.

### Criptografia Simétrica
- Utiliza **uma única chave** para criptografar e descriptografar.
- É **mais rápida** e eficiente para grandes volumes de dados.
- Requer que a chave seja compartilhada de forma segura entre as partes.
- **Exemplo de algoritmo**: AES (Advanced Encryption Standard).

### Criptografia Assimétrica
- Utiliza **duas chaves**: uma pública para criptografar e uma privada para descriptografar.
- **Mais segura** para comunicação entre partes desconhecidas.
- É mais lenta e geralmente usada para troca de chaves ou pequenas quantidades de dados.
- **Exemplo de algoritmo**: RSA (Rivest-Shamir-Adleman).

### Exemplos práticos:
- **Simétrica (AES)**: usada para criptografar arquivos armazenados em um sistema de backup. Por exemplo, um serviço de nuvem pode usar AES para proteger arquivos dos usuários.
- **Assimétrica (RSA)**: utilizada em conexões HTTPS, onde a chave pública do servidor é usada para transmitir dados de forma segura, e somente o servidor pode ler com sua chave privada.

---

## Questão 3: Mitigação de Ataques

Abaixo estão três ataques comuns a aplicações web e como mitigá-los:

### 1. XSS (Cross-site Scripting)
- **Descrição**: Permite que scripts maliciosos sejam injetados e executados no navegador de outros usuários.
- **Mitigação**: 
  - Sanitizar e escapar entradas do usuário.
  - Implementar Content-Security-Policy (CSP).
  - Evitar renderizar conteúdo HTML dinâmico sem validação.

### 2. CSRF (Cross-site Request Forgery)
- **Descrição**: Leva o usuário autenticado a executar ações não autorizadas em uma aplicação web.
- **Mitigação**:
  - Utilizar **tokens CSRF** únicos por sessão.
  - Configurar cookies com atributo `SameSite=Strict`.
  - Validar origem das requisições HTTP (verificando headers `Origin` ou `Referer`).

### 3. SQL Injection
- **Descrição**: Permite que um atacante insira comandos SQL maliciosos por meio de entradas da aplicação.
- **Mitigação**:
  - Utilizar **prepared statements** (consultas parametrizadas).
  - Validar e escapar todas as entradas do usuário.
  - Restringir permissões do banco de dados.
