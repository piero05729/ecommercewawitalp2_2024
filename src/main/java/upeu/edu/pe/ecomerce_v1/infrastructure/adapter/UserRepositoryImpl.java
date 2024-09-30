/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecomerce_v1.infrastructure.adapter;

import org.springframework.stereotype.Repository;
import upeu.edu.pe.ecomerce_v1.app.repository.UserRepository;
import upeu.edu.pe.ecomerce_v1.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
@Repository
public class UserRepositoryImpl implements UserRepository{
    private UserCrudRepository userCrudRepository;

    public UserRepositoryImpl(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    @Override
    public UserEntity created(UserEntity userEntity) {
       return  userCrudRepository.save(userEntity); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UserEntity findByEmail(String email) {
       return userCrudRepository.findByEmail(email).get(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UserEntity finById(Integer id) {
        return userCrudRepository.findById(id).get(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
