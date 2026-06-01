<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
</head>
<body>

    <h1>Login</h1>

    <% String error = (String) request.getAttribute("error");
       if (error != null) { %>
        <p style="color: red;"><%= error %></p>
    <% } %>

    <form action="/demo/form" method="POST">
        
        <label>User Name:</label>
        <input type="text" name="username" placeholder="admin">

        <label>Password:</label>
        <input type="password" name="password" placeholder="admin123">

        <button type="submit">Register</button>

    </form>
    
</body>
</html>