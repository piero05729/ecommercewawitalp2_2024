/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ecomerce_v1.app.repository;

import org.springframework.stereotype.Repository;
import upeu.edu.pe.ecomerce_v1.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
@Repository
public interface UserRepository {
    //crea un nuevo usuario
    public abstract UserEntity created(UserEntity userEntity);
    public UserEntity findByEmail(String email);
    public UserEntity finById(Integer id);
}
