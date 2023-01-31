package org.nagarro.ProductMicroservice.api;

import org.nagarro.ProductMicroservice.models.Product;
import org.nagarro.ProductMicroservice.services.ProductService;
import org.nagarro.ProductMicroservice.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v2/products")
public class ProductController {

    @Autowired
    ProductService productService;

    //Create
     @PostMapping("/prod")
    public ResponseEntity<Product> createProd(@RequestBody Product product){
        Product savedProducts = this.productService.createProduct(product);
        return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);
    }

    //Update
    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> updateProd(@RequestBody Product product, @PathVariable Integer productId){
        Product updatedProduct = this.productService.updateProduct(product,productId);
        return ResponseEntity.ok(updatedProduct);
    }

    //Get all products
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProds() {
        return ResponseEntity.ok(this.productService.getAllProducts());
    }

    //Get single product
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProd(@PathVariable Integer productId) {
        return  ResponseEntity.ok(this.productService.getSingleProduct(productId));
    }

    //Delete product
    @DeleteMapping("delete/{productId}")
    public ResponseEntity<ApiResponse> delProd(@PathVariable Integer productId) {

        this.productService.deleteProduct(productId);
        return new ResponseEntity<ApiResponse>(new ApiResponse
                ("Product Deleted Successfully", true), HttpStatus.OK);
    }

}
