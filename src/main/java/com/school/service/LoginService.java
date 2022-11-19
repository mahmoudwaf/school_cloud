package com.school.service;

import com.school.entity.RoleEntity;
import com.school.entity.UserEntity;
import com.school.model.Role;
import com.school.model.User;
import com.school.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LoginService {
    @Autowired
    UserRepository userRepo;

    public User saveUser(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());
        userEntity.setRoles(mapToRoleEntitySet(user.getRoles()));
        userEntity = userRepo.save(userEntity);
        user.setUserId(userEntity.getUserId());
        return user;
    }

    private Set<RoleEntity> mapToRoleEntitySet(Set<String> rolesNames){
        return rolesNames.stream().map(role -> {
             RoleEntity re = new RoleEntity();
             re.setRoleName(role);
            // re.setUserId(new Long(1));
             return re;
        }).collect(Collectors.toSet());
    }

    private List<User> mapToUsers(List<UserEntity> users){
        return users.stream().map(userEntity -> {
            User user = new User();
            user.setUserId(userEntity.getUserId());
            user.setUsername(userEntity.getPassword());
            user.setEmail(userEntity.getEmail());
            user.setRoles(userEntity.getRoles().stream().map(roleEntity -> roleEntity.getRoleName()).collect(Collectors.toSet()));
            return user;
        }).collect(Collectors.toList());
    }

    public List<User> getAllUsers(){
        return mapToUsers(userRepo.findAll());
    }

    public void deleteUser(long userId){
        userRepo.deleteById(userId);
    }


}
