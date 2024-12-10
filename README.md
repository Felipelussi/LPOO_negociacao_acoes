# Negociação de ações

![image](https://github.com/user-attachments/assets/7c6a4e03-00f9-4631-91cd-2afe25ce25bc)

O sistema de negociação de ações visa permitir o acompanhamento de transação de ações entre múltiplos usuários. As funcionalidades básicas são:

- Cadastro de usuários
- Cadastro de ações
- Realização de negócios
- Acompanhamento do portfólio dos usuários

## Funcionamento

A aba de usuário fornece uma forma de realizar o acompanhento dos usuários e suas ações. Ela é implementada por um pelo User.Java, que executa a lógica necessária para cada funcionalidade e delega as funções de persistencia para o objeto jpa.

A aba de Ações permite o cadastro e acompanhamento do preço das ações. É implementada pelo arquivo Empresas.java.

A aba de Negócios permite a realização de transações de ações entre dois usuários. Ela é implementada pela classe Negocios.java, que busca as opções de usuários por meio do hibernate e realiza a criação de novas entidades Negocio com os dados selecionados pelo usuário.
