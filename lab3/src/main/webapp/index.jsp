<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>SQL Query Executor</title>
</head>
<body>
    <h2>SQL-запити для таблиць bikebrand, shop, product</h2>
    
    <!-- Форма -->
    <h3>Введіть запит:</h3>
    <form action="ExecuteQueryServlet" method="POST">
        <input type="hidden" name="table" value="street">
        <textarea name="query" rows="4" cols="50" placeholder="Наприклад: SELECT * FROM bikebrand;"></textarea><br><br>
        <input type="submit" value="Виконати запит">
    </form>

    <div id="results">
        <h3>Результат запиту:</h3>
        ${queryResult}
    </div>
</body>
</html>
