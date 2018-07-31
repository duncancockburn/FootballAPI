package football.Service;

import football.Mapper.UserMapper;
import football.Model.User;
import football.exceptions.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

@Service

public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    AuthService authService;

    @Autowired
    RestTemplate restTemplate;


    //get all users using com
    public ArrayList<User> getAllUsers (){
        ArrayList<User> list = userMapper.getAllUsers();
        return list;
    }

    //get user by id
    public User getById(int id) throws InvalidRequestException {
        try {
            int tempId = userMapper.checkIfSectionExists(id);
        } catch (Exception npe){
            throw new InvalidRequestException("Unknown section: " + id, 400);

        }
        return userMapper.getByID(id);
    }




    //add new user
    public User addNew(User user) {
        String key = null;
        try {
            key =authService.createApiKey();
            user.setApiKey(key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //check for duplicate key
        while(authService.security(key) == true){
            try {
                user.setApiKey(authService.createApiKey());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        userMapper.insertUser(user);
        return userMapper.getByAPIKey(user.getApiKey());
}


    //update user by its id
    public User updateById(User user) {
        userMapper.updateUser(user);
        return userMapper.getByAPIKey(user.getApiKey());
    }

    //delete
    public User deleteById(int id) {
        userMapper.deleteUser(id);
        return userMapper.getByID(id);
    }
}
