<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"
    uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Usuários Cadastrados</title>
</head>
<body>

<h1>Lista de Usuários</h1>

<table border="1">

    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Email</th>
    </tr>

    <c:forEach items="${usuarios}" var="usuario">

        <tr>
            <td>${usuario.id}</td>
            <td>${usuario.nome}</td>
            <td>${usuario.email}</td>
        </tr>

    </c:forEach>

</table>

<br>

<a href="index.html">
    Novo Cadastro
</a>

</body>
</html>