package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return productService.add(product);
    }

    @GetMapping("/getByProductName}")
    public DataResult<Product> getByProductName(@RequestParam("productName") String productName){
        return productService.findByProductName(productName);
    }

    @GetMapping("/findByProductNameAndCategoryId")
    public DataResult<Product> findByProductNameAndCategoryId(@RequestParam("productName") String productName,
                                                              @RequestParam("categoryId") int categoryId){
        return productService.findByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping("/findByCategoryIdIn")
    public DataResult<List<Product>> findByCategoryIdIn(@RequestParam("productName") List<Integer> ids){
        return productService.findByCategoryIdIn(ids);
    }

    @GetMapping("/findByProductNameContains")
    public DataResult<List<Product>> findByProductNameContains(@RequestParam("productName") String productName){
        return productService.findByProductNameContains(productName);
    }

    @GetMapping("/findByProductNameStartsWith")
    public DataResult<List<Product>> findByProductNameStartsWith(@RequestParam("productName") String productName){
        return productService.findByProductNameStartsWith(productName);
    }

    @GetMapping("/findByNameAndCategory")
    public DataResult<List<Product>> findByNameAndCategory(@RequestParam("productName") String productName,
                                                           @RequestParam("categoryId") int categoryId){
        return productService.findByNameAndCategory(productName, categoryId);
    }

}
