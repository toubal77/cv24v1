<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des CV</title>
</head>
<body>
    <h1>Liste des CV</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
        </tr>
        <% for (CV24type cv24 : cv24s) { %>
            <tr>
                <td><%= cv24.getId() %></td>
                <td><%= cv24.getIdentite().getNom() %></td>
                <td><%= cv24.getIdentite().getPrenom() %></td>
            </tr>
        <% } %>        
    </table>
</body>
</html>
