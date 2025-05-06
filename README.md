# Ac2-Ciber
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
