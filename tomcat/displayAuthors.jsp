<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Authors Table</title>
</head>
<body>
    <h1>Authors Table</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Country</th>
        </tr>
        <% 
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                // Load the Derby JDBC driver
                Class.forName("org.apache.derby.jdbc.ClientDriver");

                // Establish the connection
                String url = "jdbc:derby://localhost:1527/authors;create=true";
                conn = DriverManager.getConnection(url);

                // Create a statement
                stmt = conn.createStatement();

                // Execute a query
                String sql = "SELECT * FROM authors";
                rs = stmt.executeQuery(sql);

                // Process the result set
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String country = rs.getString("country");
        %>
        <tr>
            <td><%= id %></td>
            <td><%= name %></td>
            <td><%= country %></td>
        </tr>
        <% 
                }
            } catch (Exception e) {
                e.printStackTrace();
        %>
        <tr>
            <td colspan="3">Error: <%= e.getMessage() %></td>
        </tr>
        <% 
            } finally {
                // Close resources
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        %>
    </table>
</body>
</html>
