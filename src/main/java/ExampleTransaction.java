import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleTransaction {
    public static void main(String[] args) {
        try(Connection connection = MysqlConnection.getConnection()) {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            statement.execute("UPDATE products SET price=300 WHERE id=3;");
            statement.execute("UPDATE products SET price=600 WHERE id=4;");

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
