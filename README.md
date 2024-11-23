# Trabalho DAC20242 – Desenvolvimento de Aplicações Corporativas 2024.2

## Descrição

Este projeto tem como objetivo a criação de um sistema para gerenciar usuários. O sistema permite o cadastro, edição, exclusão e listagem de usuários, persistindo os dados em um banco de dados PostgreSQL. O projeto utiliza as tecnologias JSF, PrimeFaces, Hibernate e JPA (Java Persistence API) para realizar as operações CRUD.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação para implementação da lógica de negócio.
- **JSF (JavaServer Faces)**: Framework para construção de interfaces web dinâmicas.
- **PrimeFaces**: Biblioteca para componentes UI (User Interface) avançados no JSF.
- **Hibernate**: Framework ORM (Object-Relational Mapping) para persistência de dados.
- **PostgreSQL**: Sistema de banco de dados utilizado para persistência.
- **Eclipse**: Ambiente de desenvolvimento utilizado para programação.
- **Tomcat**: Servidor de aplicação para rodar a aplicação web.

## Funcionalidades

- Cadastro de usuários com validação de nome e data de nascimento.
- Edição, exclusão e listagem de usuários.
- Contagem de usuários registrados na tabela.
- Visualização completa de um usuário selecionado.
- Interface com a página de cadastro e listagem de usuários.

## Instruções de Execução

### Pré-requisitos

1. **Instalar o PostgreSQL**: Certifique-se de que o PostgreSQL está instalado e rodando na sua máquina.
2. **Configuração do banco de dados**:
   - Crie um banco de dados no PostgreSQL com o nome `usuarios_db`.
   - Configure a conexão com o banco no arquivo `persistence.xml`.

### Como configurar
https://www.youtube.com/watch?v=BgSN4j6Zwwg

### Passos

1. **Configuração do Banco de Dados**:
   - No arquivo `persistence.xml`, configure a conexão com o banco de dados PostgreSQL.

2. **Deploy da aplicação**:
   - Importe o projeto no Eclipse.
   - Compile o código e faça o deploy no Tomcat.

3. **Acessando a aplicação**:
   - Após rodar a aplicação, abra o navegador e acesse:
     - Página de cadastro de usuário: `/cadastro_usuario.xhtml`
     - Página de listagem de usuários: `/listagem_usuarios.xhtml`

4. **Interações principais**:
   - Na página de cadastro de usuário, preencha os campos obrigatórios e clique em "Salvar".
   - Na página de listagem de usuários, você pode visualizar, excluir e contar o número de usuários cadastrados.

### Arquivos Importantes

- **`Usuario.java`**: Classe de entidade com as variáveis `id`, `nome`, `sexo`, `senha` e `dataNascimento`.
- **`UsuarioDAO.java`**: Classe de acesso a dados (DAO) para realizar as operações CRUD no banco.
- **`UsuarioBean.java`**: Classe de managed bean responsável pela comunicação entre as páginas de cadastro e listagem.
- **`persistence.xml`**: Configuração de persistência JPA, onde é definida a conexão com o banco de dados.
- **`cadastro_usuario.xhtml`**: Página de cadastro de usuários.
- **`listagem_usuarios.xhtml`**: Página de listagem de usuários.

### Funcionalidades Implementadas

1. **Cadastro de Usuário**: Permite a inserção de dados de um novo usuário no sistema.
2. **Edição de Usuário**: Permite editar os dados de um usuário já cadastrado.
3. **Exclusão de Usuário**: Permite excluir um usuário da base de dados.
4. **Listagem de Usuários**: Exibe uma lista de usuários cadastrados com a opção de visualizar, editar e excluir.
5. **Validação de Dados**: Ao salvar ou editar um usuário, o sistema verifica se já existe um usuário com o mesmo nome e data de nascimento.
6. **Contagem de Usuários**: Exibe o total de usuários cadastrados no sistema.


## Como Testar

1. **Cadastrar Usuário**: Acesse a página `/cadastro_usuario.xhtml`, preencha o formulário e clique em "Salvar".
2. **Listar Usuários**: Acesse a página `/listagem_usuarios.xhtml` para visualizar todos os usuários cadastrados.
3. **Exclusão de Usuário**: Na página de listagem de usuários, selecione um usuário e clique em "Excluir".
4. **Contagem de Usuários**: Na página de listagem, clique no botão "Contar Usuários" para exibir o número total de usuários.

## Contribuições

Este trabalho foi realizado em dupla, com cada membro responsável por partes específicas do código. Ambos os integrantes revisaram e entenderam todas as implementações para garantir o bom funcionamento do sistema.

## Autores

- [**Nome do Autor 1**](https://github.com/KauanCarolino)
- [**Nome do Autor 2**](https://github.com/mfpontes)

## Licença

Este projeto está licenciado sob a Licença MIT - consulte o arquivo [LICENSE](LICENSE) para mais detalhes.
