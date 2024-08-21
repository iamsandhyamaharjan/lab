<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Temperature Conversion Chart</title>
</head>
<body>
    <table border="1">
        <caption>Temperature Conversion Chart</caption>
        <tr>
            <th>Celsius</th>
            <th>Fahrenheit</th>
        </tr>
        <% 
        for (int c = 0; c <= 100; c += 20) {
            double f = (c * 9) / 5.0 + 32; 
        %>
            <tr>
                <td><%= c %></td>
                <td><%= f %></td>
            </tr>
        <% 
        } 
        %>
    </table>
</body>
</html>
