package com.cydeo.service;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO, String> {

    List<UserDTO>findManagers();

    // UserDTO save(UserDTO user);          //abstract
    //  UserDTO findById(String username);
    //  List<UserDTO> findAll();
    // void deleteById(String username);
// delete these methods and extend CrudServices and pass parameters
}