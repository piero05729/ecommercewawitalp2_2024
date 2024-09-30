/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ecomerce_v1.app.repository;

import org.springframework.stereotype.Repository;
import upeu.edu.pe.ecomerce_v1.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ecomerce_v1.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
@Repository
public interface ProductRepository {
       //lista de todos los productos
    Iterable<ProductEntity>getProducts();
    //lista de Productos x usuarios
    Iterable<ProductEntity>getProductByUser(UserEntity userEntity);
    ProductEntity getProductById(Integer id);
    ProductEntity saveProduct(ProductEntity productEntity);
    boolean deleteProductById(Integer id);
}
