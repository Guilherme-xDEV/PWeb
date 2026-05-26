Respostas das Atividades Propostas

3.
Explicar o papel de cada Componente MVC e como interagem entre sí para prcessar requisições dos usuários e gerar respostas adequadas.

Model: É uma 'camada' que Delimita, por exemplo, regras de negócio, lógica de negócios, regras de validação e armazenamento/recuperação de informações, sem a dependência da interface.

View: É a camadada responsável pela apresentação dos dados ao usuário, exibindo informações e recebendo entradas, sem conter as regras de negócio.

Controller: Responsável pela comunicação entre view e model. Recebe as requisições e solicitações do usuário e através de sua comunicação com a camada model, processa essas informações e direciona elas para a camada view onde serão mostradas.
Seu funcionamento conciste em selecionar algum componente da camada model, onde são processados e em seguida manda esses dados para a camada view.


4. 
Na camada de Controller, em um servlet, as requisições HTTP são processadas usando o ecossistema que permite comunicação (no nosso caso o jakarta), onde extendemos na classe, HttpServlet e usamos o método doPost() e nele definimos as variáveis que queremos acessar e em seguida definir os dados. O sevlet segue um processo de vida útil e tem um início e fim, com liberação de recursos. Cabeçalhos como Content-Type, podem ser difinidos através do HttpServvletResponse, fornecido no método de tratamento de requisição como doGet ou doPost.
Para especificar o tipo de conteúdo, usa-se setContentType() ou setHeader().

5.
a)
Na camada MVC, arquivos estáticos como o HTML, CSS e JavaScript além de arquivos jsp ficam dentro da camada view e são processados em um navegador, eles são responsáveis por duas coisas: 1. permitir que o usuário entre conteúdos (um formulário por exemplo). 2. permitir que as respostas sejam passadas pelo servlet e mostradas depois de terem sido processadas. De modo geral a reposta é processada pelo servlet e só então devolvida. Podemos usar Expression Language para receber os dados.

b)
webapp. Esse é o nome da pasta que armazena arquivos estáticos. Sim, arquivos dentro dessa página podem ser acessados pelo navegador uma vez que são processados lá.

c)
A pasta webapp também pode ser usada para armazenar arquivos dinâmicos como o JSP que enviam e recebem dados.Esses arquivos de código podem ser disponíveis para visualização no navegador em modo de inspeção de modo que é possível acessar o código do arquivo, mas os dados que são enviados por esses arquivos podem ser acessíveis apenas pelo controller.

De acordo com o Google:
Os files tipo jsp também podem ser armazenados no diretório WEB-INF da estrutura do projeto e não são acessíveis publicamente pela URL diretamente. O acesso a esses arquivos se dá pelo controlador como um servlet que irá processar a solicitação e encaminhar internamene para a página JSP
