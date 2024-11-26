package com.business.management.mapper;

import com.business.management.dto.UserDTO;
import com.business.management.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDTO userToDTO(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());

        return dto;
    }


    public static User dtoToUser(UserDTO dto){
        User user = new User();
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        return user;
    }
}
