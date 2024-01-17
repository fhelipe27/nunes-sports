# Nunes Sports - Aplicação Web

## Visão Geral
Este é um projeto de aplicação web desenvolvida em Java com Spring Boot, Spring Data JPA, Thymeleaf, Lombok, HTML, CSS e Bootstrap. A aplicação permite aos usuários gerenciar uma lista de produtos, incluindo adição, edição e exclusão de produtos.

## Diagrama UML:

```mermaid
classDiagram
    class ProdutoController {
        +produtoService: ProdutoService
        +create(produto: Produto): String
        +produtos(): ModelAndView
        +editar(id: Long): ModelAndView
        +deletar(id: Long): String
    }

    class Produto {
        -id: long
        -nome: String
        -codigo: String
        -descricao: String
        -preco: BigDecimal
    }

    class ProdutoService {
        -produtoRepository: ProdutoRepository
        +salvarProduto(produto: Produto): Produto
        +buscarPorId(id: Long): Optional<Produto>
        +buscarTodos(): List<Produto>
        +deletarPorId(id: Long): void
        +editarPorId(id: Long, produtoAtualizado: Produto): Produto
    }

    class ProdutoRepository {
        // Spring Data JPA repository
    }

    ProdutoController --> ProdutoService: <<Autowired>>
    ProdutoController --> Produto: <<Autowired>>
    ProdutoService --> ProdutoRepository: <<Autowired>>
    ProdutoService --> Produto: <<Autowired>>
```


## Imagens da Aplicação:

![image](https://github.com/fhelipe27/nunes-sports/assets/68212163/4b22e1b2-0192-4293-b0b7-da56a69847eb)


## Tecnologias Utilizadas
- Java
- Spring Boot
- Spring Data JPA
- Thymeleaf
- Lombok
- MySQL (como banco de dados)
- HTML
- CSS
- Bootstrap

## Iniciando
Para executar a aplicação localmente, siga os passos abaixo:

1. Clone o repositório:
    ```bash
    git clone https://github.com/fhelipe27/nunes-sports
    ```
2. Abra o projeto em seu IDE preferido.
3. Configure a conexão com o banco de dados MySQL no arquivo application.properties. Certifique-se de criar o banco de dados antes de iniciar a aplicação.
4. Execute a aplicação.
5. Acesse a aplicação no navegador através do endereço http://localhost:8080/api/v1/produtos

## Funcionalidades
A aplicação oferece as seguintes funcionalidades:
- Adição de produtos através do formulário.
- Edição de produtos existentes.
- Exclusão de produtos da lista.
- Listagem geral dos produtos incluídos no banco de dados

## Estrutura do Projeto
- src/main/java/com/everymind/nunessports/controllers: Contém os controladores da aplicação.
- src/main/java/com/everymind/nunessports/services: Contém os serviços relacionados aos produtos.
- src/main/resources/templates: Contém os arquivos HTML usando Thymeleaf para renderizar as páginas.

## Contribuição
Sinta-se à vontade para contribuir com melhorias, correções de bugs ou novas funcionalidades. Abra um pull request e ficarei feliz em revisar.

