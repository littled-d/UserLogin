package cn.xiejp.dao;

import cn.xiejp.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int add(User user);

    int delete(@Param("mobile") String mobile);

    int update(User user);

    User select(@Param("mobile") String mobile);

    List<User> selectAll();

}