package cn.xiejp.service;

import cn.xiejp.dao.UserMapper;
import cn.xiejp.pojo.User;

import java.util.List;

public class UserServiceImpl implements UserService{

    // 业务层调用dao层就对了； 组合dao层
    private UserMapper userMapper;

    // setter 方法，等会儿Spring直接注入
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int delete(String mobile) {
        return userMapper.delete(mobile);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public User select(String mobile) {
        return userMapper.select(mobile);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
