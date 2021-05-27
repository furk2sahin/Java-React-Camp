package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.*;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao){
        super();
        this.productDao = productDao;
    }

    @Override
    public Result add(Product product) {
        try{
            productDao.save(product);
            return new SuccessResult("Ürün eklendi");
        } catch (Exception e){
            return new ErrorResult("Ürün eklenemedi");
        }
    }

    @Override
    public DataResult<List<Product>> getAll(){
        return new SuccessDataResult<>(
                this.productDao.findAll(),
                "Data listelendi"
        );
    }

    @Override
    public DataResult<List<Product>> getAllPaged(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return new SuccessDataResult<>(
                productDao.findAll(pageable).getContent(),
                "Data listelendi"
        );
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<>(
                productDao.findAll(sort),
                "Data listelendi"
        );
    }

    @Override
    public DataResult<Product> findByProductName(String productName) {
        return new SuccessDataResult<>(
                this.productDao.findByProductName(productName),
                "Data listelendi"
        );
    }

    @Override
    public DataResult<Product> findByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(
                this.productDao.findByProductNameAndCategoryId(productName, categoryId),
                "Data listelendi"
        );
    }

    @Override
    public DataResult<List<Product>> findByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(
                this.productDao.findByProductNameOrCategoryId(productName, categoryId),
                "Data listelendi"
        );
    }

    @Override
    public DataResult<List<Product>> findByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<>(
                this.productDao.findByCategoryIdIn(categories),
                "Data listelendi"
        );
    }

    @Override
    public DataResult<List<Product>> findByProductNameContains(String productName) {
        return new SuccessDataResult<>(
                this.productDao.findByProductNameContains(productName),
                "Data listelendi"
        );
    }

    @Override
    public DataResult<List<Product>> findByProductNameStartsWith(String productName) {
        return new SuccessDataResult<>(
                this.productDao.findByProductNameStartsWith(productName),
                "Data listelendi"
        );
    }

    @Override
    public DataResult<List<Product>> findByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<>(
                this.productDao.findByNameAndCategory(productName, categoryId),
                "Data listelendi"
        );
    }
}
