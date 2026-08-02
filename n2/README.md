<h3>Relatório De Prática + Anotações De Estudo</h3>


<ul>1. Criei o projeto usando Maven Archetype</ul>
<ul>2. Coloqui as dependências no pom.xml e criei persistence.xml em resources/META-INF</ul>
<ul>3. Criei os pacotes db e entities seguindo a segunda parte do artigo</ul>
<ul>4. Comecei a modelagem das entidades inicialmente sem annotations</ul>
<ul>5. Adicionei as annotations conforme o artigo</ul>
<ul>6. Adicione as colunas de relações entre as tabelas (FK) e suas relações de mapeamento</ul>
<ul>7. Teste de criação e gerenciamento de objetos mapeados usando EntityManager no Main</ul>
<ul>8. Criação Do DBFactory para gerenciar Entidades e Classes do DAO</ul>
<ul>9. Teste da nova arquitetura com código no Main </ul>

A anotação @JoinColumn, na entidade Curso, define a coluna que será utilizada para armazenar a chave estrangeira que referencia o instrutor.

Usar a anotação @JoinColumn é como dizer ao Hibernate que quando aquela variável for mapeada em uma coluna no banco de dados, esta deverá ser uma chave estrangeira, ou seja esse atributo fará a comunicação entre as duas tabelas.