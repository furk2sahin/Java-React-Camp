package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAllPaged(int pageNo, int pageSize);
    DataResult<List<Product>> getAllSorted();
    Result add(Product product);

    DataResult<Product> findByProductName(String productName);
    DataResult<Product> findByProductNameAndCategoryId(String productName, int categoryId);
    DataResult<List<Product>> findByProductNameOrCategoryId(String productName, int categoryId);
    DataResult<List<Product>> findByCategoryIdIn(List<Integer> categories);
    DataResult<List<Product>> findByProductNameContains(String productName);
    DataResult<List<Product>> findByProductNameStartsWith(String productName);
    DataResult<List<Product>> findByNameAndCategory(String productName, int categoryId);
}
