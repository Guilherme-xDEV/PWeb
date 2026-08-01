## Questões Práticas 1-3

## 1.
De acordo com o enunciado o cookie possui os atributos: 'HttpOnly' e 'Secure', esses atributos definidos na criação do cookie, especialmente o 'HttpOnly', impede um cliente (navegador) de acessar o conteúdo do cookie com javaScript fazendo 'document.cookie'. A afirmação dos estudantes de que a sessão não foi criada por não conseguirem acessar o valor de 'JSESSIONID' está equivocada.
Para verificar a sessão, pode-se confirmar no painel Application/Storage do navegador e também na aba Network onde pode-se ver se o cookie JSESSIONID é enviado nas requisições subsequentes ao servidor.

## 2.
A implementação atual é insegura porque utiliza um cookie persistente para armazenar a identidade do estudante, sem os atributos HttpOnly e Secure, permitindo acesso por scripts e aumentando o risco de roubo de sessão. A solução recomendada em Jakarta EE é utilizar HttpSession para armazenar os dados do usuário autenticado, deixando que o contêiner gerencie o cookie JSESSIONID. Durante o login, deve-se criar uma sessão e armazenar nela os dados necessários do usuário. O cookie de sessão deve possuir os atributos HttpOnly, Secure e Path adequado. No logout, é necessário invalidar a sessão com session.invalidate() e remover os cookies associados utilizando setMaxAge(0), garantindo que o usuário não permaneça autenticado após encerrar a sessão.

Proposta de solução: <br>
1. Login:

String usuario = request.getParameter("usuario");
String senha = request.getParameter("senha");

HttpSession session = request.getSession();
session.setAttribute("usuario", usuario);

response.sendRedirect("home.jsp");

2. Logout:
HttpSession session = request.getSession(false);

if (session != null) {
    session.invalidate();
}

Cookie cookie = new Cookie("JSESSIONID", "");
cookie.setMaxAge(0);
cookie.setPath(request.getContextPath());
response.addCookie(cookie);

response.sendRedirect("index.jsp");

## 3.

__1 Código de Criação do Cookie__ <br>
String idioma = request.getParameter("idioma"); // pt, en ou es

Cookie idiomaCookie = new Cookie("idioma", idioma);
idiomaCookie.setMaxAge(60 * 60 * 24 * 30); // 30 dias
idiomaCookie.setPath(request.getContextPath());

response.addCookie(idiomaCookie);

response.getWriter().println("Preferência de idioma salva com sucesso.");

__2 Código para Leitura em Requisições Subsequentes__ <br>
String idioma = "pt"; // idioma padrão

Cookie[] cookies = request.getCookies();

if (cookies != null) {
    for (Cookie cookie : cookies) {
        if ("idioma".equals(cookie.getName())) {
            idioma = cookie.getValue();
            break;
        }
    }
}

__3 Código de Aplicação de Preferência__ <br>
if ("en".equals(idioma)) {
    response.getWriter().println("Welcome to the Online Courses Platform!");
}
else if ("es".equals(idioma)) {
    response.getWriter().println("¡Bienvenido a la Plataforma de Cursos Online!");
}
else {
    response.getWriter().println("Bem-vindo à Plataforma de Cursos Online!");
}

## Questões Teóricas 1-10

## 1. Qual das alternativas descreve corretamente a principal função de um cookie?

a) Armazenar objetos Java no servidor para compartilhamento entre usuários.

b) Permitir que o servidor execute código JavaScript no navegador do cliente.

c) Armazenar pequenas informações no navegador do usuário para que possam ser reutilizadas em requisições futuras.

d) Criar conexões permanentes entre cliente e servidor.

Resposta: C) Um Cookie armazena informações na forma chave-valor que servem para otimizar a experiência do usuário permitindo funcionalidades essenciais.

---

## 2. Considere o seguinte cenário: um usuário acessa uma loja virtual, adiciona produtos ao carrinho e navega por diversas páginas antes de finalizar a compra.

Qual mecanismo é mais adequado para armazenar temporariamente os itens do carrinho durante a navegação?

a) Cookies contendo todos os dados dos produtos.

b) Variáveis locais de cada Servlet.

c) Sessão HTTP associada ao usuário.

d) Arquivos HTML armazenados no navegador.

Resposta: C) Nessa situação, uma sessão seria o ideal pois permite identificar o carrinho associado a um usuário, por exemplo por um Id. Mantêm estado temporário de um usuário durante navegação. A persistência de uma sessão pode exigir um token que é salvo no banco de dados. Nas próximas requisições o servidor consulta o token.

---

## 3. Sobre o protocolo HTTP, assinale a alternativa correta.

a) O HTTP mantém automaticamente o histórico completo das interações de cada usuário.

b) O HTTP é um protocolo orientado a estado.

c) O HTTP é considerado um protocolo stateless (sem estado).

d) O HTTP utiliza sessões automaticamente sem necessidade de configuração.

Resposta: C) O HTTP não possui estado, por isso, usamos cookies e Sessões para manter preferências/dados do usuário a medida que ele acessa outras páginas dentro do mesmo domínio.

---

## 4. Ao criar um cookie em uma Servlet utilizando a API Java, qual método é utilizado para enviar o cookie ao navegador do cliente?

a) `request.addCookie(cookie)`

b) `response.addCookie(cookie)`

c) `session.addCookie(cookie)`

d) `cookie.send()`

Resposta: B) response.addCookie(nomeDoCookie) é o método usado para enviar um cookie, criado no servidor e enviado ao navegador.

---

## 5. Uma plataforma de cursos online deseja lembrar o idioma preferido do usuário mesmo após ele fechar o navegador e retornar dias depois.

Qual solução é mais apropriada?

a) Armazenar a preferência em um atributo da requisição (`request`).

b) Armazenar a preferência em uma variável local da Servlet.

c) Armazenar a preferência em um cookie persistente.

d) Armazenar a preferência exclusivamente em uma sessão HTTP.

Resposta: C) Um Cookie é ideal para armazenar informações de customização como tema, idioma, layout, etc. No java jakarta EE podemos usar o método 'setMaxAge()' para garantir persistência.

---

## 6. Analise as afirmações a seguir sobre sessões HTTP:

I. Cada usuário normalmente possui sua própria sessão.

II. Os dados da sessão são armazenados no servidor.

III. A sessão pode ser encerrada automaticamente após um período de inatividade.

Assinale a alternativa correta.

a) Apenas I.

b) Apenas I e II.

c) Apenas II e III.

d) I, II e III.

Resposta: D) I, II e III.
I: Verdadeiro já que o seridor identifica o usuário por sua sessão única.

II: Verdadeiro (na forma tradicional), dados de sessão podem ser armazenados em um servidor, mas soluções como o JWT reduzem a necessidade de armazenar dados em banco.

III: Verdadeiro: A sessão pode ter tempo em caso de inatividade definida no servidor.

---

## 7. Uma empresa desenvolveu um sistema acadêmico onde cada aluno, ao realizar login, recebe um identificador de sessão único. O sistema utiliza esse identificador para recuperar informações do aluno durante toda a navegação.

Qual é o principal benefício dessa abordagem?

a) Reduzir o tamanho das páginas HTML.

b) Evitar que o servidor precise armazenar informações do usuário.

c) Permitir a identificação e manutenção do contexto do usuário entre múltiplas requisições.

d) Eliminar a necessidade de autenticação.

Resposta: C) O HTTP é <i>stateless</i>, usar um Id permite reconhecer o usuário entre requisições sem que este precise fazer login novamente a cada página acessada.

---

## 8. Quando um navegador realiza uma nova requisição para um servidor, o que normalmente acontece com os cookies previamente armazenados para aquele domínio?

a) São apagados automaticamente.

b) São enviados junto à requisição, desde que atendam às regras de domínio, caminho e validade.

c) São convertidos em atributos de sessão.

d) São enviados apenas quando o usuário realiza login.

Resposta: B) Sempre que há uma nova requisição do navegador ao servidor, este anexa cookies guardados na linha de cabeçalho Header. Mas o navegador verifica; Domínio, Caminho e Validade, se tudo ok -> envia.

---

## 9. Um desenvolvedor decide armazenar em um cookie informações sensíveis, como CPF, senha e nível de acesso do usuário, em texto puro.

Qual é o principal problema dessa decisão?

a) Os cookies não podem armazenar texto.

b) O navegador não consegue recuperar cookies após fechar a aba.

c) Informações armazenadas no cliente podem ser visualizadas, modificadas ou utilizadas indevidamente, comprometendo a segurança da aplicação.

d) O servidor não consegue ler cookies enviados pelo navegador.

Resposta: C) Informações sensiveis precisam de uma camada de segurança. Isso o Cookie não resolve por conta própria além de poder ser acessado e modificado caso não seja protegido 'httpOnly'. Cookie deve ser usado só dados genéricos como customização.

---

## 10. Uma startup desenvolveu uma plataforma web para gerenciamento de eventos. Durante os testes, a equipe identificou dois requisitos:

* O sistema deve manter o usuário autenticado enquanto ele navega entre as páginas da aplicação.
* O sistema deve lembrar a preferência de tema (claro ou escuro) mesmo após o usuário fechar o navegador e retornar dias depois.

Como arquiteto de software da equipe, explique quais mecanismos de gerenciamento de estado devem ser utilizados para atender cada requisito. Em sua resposta:

* Diferencie cookies e sessões HTTP;
* Explique onde os dados são armazenados em cada caso;
* Justifique por que cada tecnologia é mais adequada ao requisito correspondente;
* Discuta brevemente aspectos de segurança relacionados à solução proposta.


Resposta:
Req1: Deve ser usado sessão, pois o HTTP não guarda estado e a sessão permite reconhecimento do usuário.

Req2: Deve ser usado cookie, pois é uma informação de customização podendo ser armazenada localmente.

Cookies e Sessões precisam ser gerenciados devidamente para evitar ataques. No caso do Cookie, este não pode ter infomações sensíveis. Já a sessão pode ser verificada no servidor caso os dados estejam em um banco remoto. Geralmente sessão pode ter dados sensíveis então sua segurança deve ser maior que a do cookie.