package com.cydeo.service;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface RoleService extends CrudService<RoleDTO, Long> {

    //service works with DTO
// delete these methods and extend CrudServices and pass parameters
    // RoleDTO save(RoleDTO role);          //abstract
    // RoleDTO findById(Long id);
    // List<RoleDTO> findAll();
    // void deleteById(Long id);
}