import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProductDAO dao = new ProductMysqlDAO();

        // Добавление товаров в БД
        List<Product> products = Arrays.asList(
                new Product("Стул", 90),
                new Product("Телевизор", 1350),
                new Product("Ноутбук", 2350)
        );

        for(Product product : products) {
            dao.addProduct(product);
        }

        // Получение товаров из БД
        List<Product> getProducts = dao.getProducts();
        System.out.println(getProducts);

        // Обновление товара в БД
        dao.updateProduct(new Product(1,"Стул новый", 78));

        // Удаление товара из БД
        dao.deleteProduct(2);
    }
}
