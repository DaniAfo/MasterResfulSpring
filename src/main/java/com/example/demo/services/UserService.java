package com.example.demo.services;

import com.example.demo.repositories.UserRepository;
import com.example.demo.models.User;
import com.example.demo.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//Servicio
@Service
public class UserService {
    //AutoWire the UserRepository
    @Autowired
    private UserRepository userRepository;
    //getAllUserMethod
    public List<User> getAllUsers(){
        return userRepository.findAll();

    }
    //createUser Method
    public User createUser(User user){
        return userRepository.save(user);
    }
    //getUserbyId method
    public Optional<User> getUserbyId(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }
     //updateUserById
     //inputs : users y id
    public User updateUserById(long id, User user)  {
        user.setId(id);
        return userRepository.save(user);
        }
       //deleUserById method
    public void deleteUserById(Long id){
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }
    }
    //getUserByUserName
        public User getUserByUserName(String username) { //recibe por parámetro obviamente el nombre)
            return userRepository.findByUsername(username);
        }





    }



