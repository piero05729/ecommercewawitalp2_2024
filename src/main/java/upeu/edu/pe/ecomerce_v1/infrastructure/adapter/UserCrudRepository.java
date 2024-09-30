/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ecomerce_v1.infrastructure.adapter;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.ecomerce_v1.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
@Repository
public interface UserCrudRepository extends CrudRepository<UserEntity, Integer>{
    //metodo adicional que no tiene el crudrpository
    public Optional<UserEntity> findByEmail(String email);
}
