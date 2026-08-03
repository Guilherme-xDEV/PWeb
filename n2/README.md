# Relatório de Prática e Anotações de Estudo

## O que foi feito

1. Criei o projeto usando Maven Archetype.
2. Adicionei as dependências no `pom.xml` e criei o `persistence.xml` em `resources/META-INF`.
3. Criei os pacotes `db` e `entities` conforme a segunda parte do artigo.
4. Modelei as entidades inicialmente sem annotations.
5. Adicionei as annotations conforme o artigo.
6. Incluí as colunas de relacionamento entre as tabelas (FK) e defini as relações de mapeamento.
7. Testei a criação e o gerenciamento de objetos mapeados usando `EntityManager` no `Main`.
8. Criei o `DBFactory` para gerenciar o `EntityManager` e as classes do DAO.
9. Testei a nova arquitetura com código no `Main`.

## Anotações sobre os artigos


### Artigo 1: Estados das entidades

Os estados das entidades são:

- `Transient`: criada no código, mas ainda não persistida no banco.
- `Managed`: persistida no banco e sendo gerenciada pelo Hibernate.
- `Detached`: persistida no banco, mas não associada ao contexto de persistência atual.
- `Removed`: marcada para remoção; ainda está em persistência mas será removida.

### Artigo 2: 

Uso de `@JoinColumn`

A anotação `@JoinColumn` na entidade `Curso` define a coluna que será usada para armazenar a chave estrangeira que referencia o `Instrutor`.

Usar `@JoinColumn` indica ao Hibernate que esse atributo deve ser mapeado como chave estrangeira, permitindo a comunicação entre as tabelas.

### Artigo 3: Arquitetura DAO

Organização Modular Do Código

1. Criação da classe DBFactory, que deve fornecer instâncias do EntityManager Para Os DAOs.

2. A arquitetura DAO (Data Access Object) é um padrão de projeto usado para modularizar componentes e separar a lógica de negócio da persistência.

O DAO é responsável por realizar as operações sobre as entidades.

