/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.senai.login.repositories;

import com.senai.login.models.ClienteModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author bruno_gs_silva
 */
public interface ClienteRepository extends JpaRepository<ClienteModel, Long>{
    public Optional<ClienteModel> findByEmail (String email);
}
