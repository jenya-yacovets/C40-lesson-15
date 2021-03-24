import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductMysqlDAO implements ProductDAO{
    @Override
    public void addProduct(Product product) {
        try {
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products (name, price) VALUES (?, ?);");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        try {
            Connection connection = MysqlConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products;");
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                Product product = new Product(id, name, price);
                products.add(product);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void updateProduct(Product product) {
        try {
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE products SET name=?, price=? WHERE id=?;");
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setInt(3, product.getId());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int id) {
        try {
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE id=?;");
            statement.setInt(1, id);
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
