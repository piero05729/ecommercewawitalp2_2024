/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecomerce_v1.infrastructure.controller;

/**
 *
 * @author tpp
 */

import jakarta.servlet.annotation.MultipartConfig;
import java.io.IOException;
import org.slf4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.ecomerce_v1.app.service.ProductService;
import upeu.edu.pe.ecomerce_v1.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ecomerce_v1.infrastructure.entity.UserEntity;
 
@RestController
@RequestMapping("api")//localhost:8080/
@CrossOrigin(origins="http://4200")
public class ProductControllerApi {
    private final ProductService productService;
    private final Logger log = LoggerFactory.getLogger(ProductControllerApi.class);

    public ProductControllerApi(ProductService productService) {
        this.productService = productService;
    }
   //crear nuevo producto
    //no es necesario pero se puede dejar ahi
    @GetMapping("/create")
   public String create(){
       return "admin/products/create";
   }
   //................
   //guardar producto
    //crear product
    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity createProduct(@RequestBody ProductEntity product, MultipartFile multipartFile) throws IOException {
        return productService.saveProduct(product,multipartFile);
    }
   @PostMapping("/save-product")
   public String saveProduct(ProductEntity productEntity, MultipartFile multipartFile) throws IOException{
       log.info("Nombre de producto:{}", productEntity);
       productService.saveProduct(productEntity,multipartFile);
      return "admin/products/create";
   //return "redirect:/admin"
   }
   @GetMapping("/show")
   @ResponseStatus(HttpStatus.OK)
   public Iterable<ProductEntity> showProduct(Model model){
       //log.infor("id user desde la variable de session:{}");
       UserEntity userEntity=new UserEntity();
       userEntity.setId(1);
       return productService.getProductsByUser(userEntity);
   }
     //buscar producto por Id
    @GetMapping("/product/{id}")
    public ProductEntity show(@PathVariable Integer id) {
        return productService.getProductById(id);
    }
   @GetMapping("/edit/{id}")
   public String editProduct(@PathVariable Integer id,Model model){
       //log.infor("id user desde la variable de session:{}");
       ProductEntity product = productService.getProductById(id);
       log.info("Product Obtenido:{}", product);
       model.addAttribute("products", product);
       return "admin/products/edit";
   }
   @GetMapping("/delete/{id}")
   public String deleteProduct(@PathVariable Integer id){
       //log.infor("id user desde la variable de session:{}");
       productService.deleteProductById(id);
       return "redirect:/admin/products/show";
   }
}
