import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {


        Class.forName("com.mysql.cj.jdbc.Driver");
        final String url = "jdbc:mysql://localhost:3306/";
        final String dbName = "dekanat";
        final String user = "root";
        final String password = "Jj-2128506";
        final String suffixSSl = "?useSSL=false";

        Connection connection = null;
        try {
             connection = DriverManager
                    .getConnection(url + dbName+suffixSSl, user, password);
            System.out.println("Connection is established!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String queryGetAll = "SELECT * FROM student";

        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery(queryGetAll);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


             try {
                 while (resultSet.next()) {
                     System.out.print(resultSet.getInt("id"));
                     System.out.println (" - " +resultSet.getString(2));
                 }
             } catch (SQLException throwables) {
                 throwables.printStackTrace();
             }finally {
                 try {
                     connection.close();
                 } catch (SQLException throwables) {
                     throwables.printStackTrace();
                 }
             }




    }
}
