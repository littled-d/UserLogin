package cn.xiejp.service;

import cn.xiejp.pojo.User;

import java.util.List;

public interface UserService {
    int add(User user);

    int delete(String mobile);

    int update(User user);

    User select(String mobile);

    List<User> selectAll();

}
