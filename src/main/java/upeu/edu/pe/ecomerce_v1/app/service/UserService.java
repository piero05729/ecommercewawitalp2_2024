/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecomerce_v1.app.service;

import upeu.edu.pe.ecomerce_v1.app.repository.UserRepository;
import upeu.edu.pe.ecomerce_v1.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
public class UserService {
    //instancia del UserRepository
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    //metodos
    public UserEntity createdUser(UserEntity userEntity){
        return  userRepository.created(userEntity);
    }
    public UserEntity findByEmail(String email){
        return  userRepository.findByEmail(email);
    }
    public UserEntity findById(Integer id){
        return  userRepository.finById(id);
    }
 
}
