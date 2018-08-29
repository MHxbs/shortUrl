package team.redrock.shorturl1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.redrock.shorturl1.entity.User;
import team.redrock.shorturl1.mapper.UserMapper;
import team.redrock.shorturl1.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean isExist(String username) {
        if (userMapper.selectOneByUsername(username)==null){
            return false;
        }else {
            return true;
        }

    }

    @Override
    public boolean passwordIsRight(String username, String password) {
        User user=userMapper.selectOneByUsername(username);
        if (user.getPassword().equals(password)){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public int insertOneUser(String username, String password) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setLimits(5);
        userMapper.insertOne(user);
        return 1;
    }
}
