package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    Product findByProductName(String productName);
    Product findByProductNameAndCategoryId(String productName, int categoryId);
    List<Product> findByProductNameOrCategoryId(String productName, int categoryId);
    List<Product> findByCategoryIdIn(List<Integer> categories);
    List<Product> findByProductNameContains(String productName);
    List<Product> findByProductNameStartsWith(String productName);

    @Modifying
    @Query("from Product where productName=:productName and category.id=:categoryId")
    List<Product> findByNameAndCategory(String productName, int categoryId);
}
