 
package upeu.edu.pe.ecomerce_v1.infrastructure.controller;

 
import java.io.IOException;
import org.slf4j.*;
import org.springframework.ui.Model;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.ecomerce_v1.app.repository.ProductRepository;
import upeu.edu.pe.ecomerce_v1.app.service.ProductService;
import upeu.edu.pe.ecomerce_v1.app.service.UploadFile;
import upeu.edu.pe.ecomerce_v1.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ecomerce_v1.infrastructure.entity.UserEntity;
@RestController
@RequestMapping("admin/products")//localhost:8080/

public class ProductController {
    private final ProductService productService;
    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
   //crear nuevo producto
    @GetMapping("/create")
   public String create(){
       return "admin/products/create";
   }
  
   //llama a un archivo de la vista
   @GetMapping("/show")
   public String showProduct(Model model){
       //log.infor("id user desde la variable de session:{}");
       UserEntity userEntity = new UserEntity();
       userEntity.setId(1);
       Iterable<ProductEntity> productEntity = productService.getProductsByUser(userEntity);
       model.addAttribute("products", productEntity);
       return "admin/products/show";
   } 
//guardar producto
   @PostMapping("/save-product")
   public String saveProduct(ProductEntity productEntity, MultipartFile multipartFile) throws IOException{
       log.info("Nombre de producto:{}", productEntity);
       productService.saveProduct(productEntity,multipartFile);
      return "admin/products/create";
   //return "redirect:/admin"
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
