/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecomerce_v1.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import upeu.edu.pe.ecomerce_v1.app.repository.ProductRepository;
import upeu.edu.pe.ecomerce_v1.app.repository.UserRepository;
import upeu.edu.pe.ecomerce_v1.app.service.ProductService;
import upeu.edu.pe.ecomerce_v1.app.service.UploadFile;
import upeu.edu.pe.ecomerce_v1.app.service.UserService;

/**
 *
 * @author tpp
 */
@Configuration
public class BeanConfiguration {
    @Bean
    public UserService userService(UserRepository userRepository){
        return new UserService(userRepository);
    }
    @Bean
    public ProductService productService(ProductRepository productRepository,UploadFile uploadFile){
        return new ProductService(productRepository, uploadFile);
    }
     @Bean
      public UploadFile uploadFile(){
        return new UploadFile();
    }
}
