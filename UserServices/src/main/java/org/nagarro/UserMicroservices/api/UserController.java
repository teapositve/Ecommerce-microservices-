package org.nagarro.UserMicroservices.api;

import org.nagarro.UserMicroservices.exceptions.ApiException;
import org.nagarro.UserMicroservices.exceptions.ResourceNotFoundException;
import org.nagarro.UserMicroservices.models.Product;
import org.nagarro.UserMicroservices.models.User;
import org.nagarro.UserMicroservices.services.UserService;
import org.nagarro.UserMicroservices.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    RestTemplate restTemplate;

    //Create User API
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){

        User createdUser = this.userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    //Update User API
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer userId){

       User updatedUser = this.userService.updateUser(user, userId);
       return ResponseEntity.ok(updatedUser);
    }

    //Get all User API
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUser());
    }

    //Get Single User
    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Integer userId){
        return  ResponseEntity.ok(this.userService.getUserById(userId));
    }

    //Delete User
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){

        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully !!", true), HttpStatus.OK);
    }

    //Create Product
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/createProduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

        Product CreatedProduct = this.restTemplate.postForObject("http://product-service/api/v2/products/prod", product, Product.class);
        return new ResponseEntity<>(CreatedProduct, HttpStatus.CREATED);
    }

    //Get all Products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {

        List products = this.restTemplate.getForObject("http://product-service/api/v2/products/all",List.class);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    //Get single Product
    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getAllProducts(@PathVariable Integer productId){
        Product product = this.restTemplate.getForObject("http://product-service/api/v2/products/" + productId, Product.class);
        if(product == null){
            throw new ApiException("Product not found !!");
        }
        return ResponseEntity.ok(product);
    }

    //Update Product
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/updateProduct/{productId}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Integer productId) {

        HttpEntity<Product> entity = new HttpEntity<>(product);

        ResponseEntity<Product> responseEntity = this.restTemplate
                .exchange("http://product-service/api/v2/products/update/" + productId, HttpMethod.PUT, entity, Product.class);

        if(responseEntity == null){
            throw new ApiException("Product not found !!");
        }
        return responseEntity.getBody();
    }

    //Delete Product
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Integer productId) {

        this.restTemplate.delete("http://product-service/api/v2/products/delete/" + productId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Product deleted Successfully !!", true), HttpStatus.OK);

    }

}
