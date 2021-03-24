import java.util.List;

public interface ProductDAO {
    void addProduct(Product product);
    List<Product> getProducts();
    void updateProduct(Product product);
    void deleteProduct(int id);
}
