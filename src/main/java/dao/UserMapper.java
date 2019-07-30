package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import pojo.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    User login(@Param("email") String email,@Param("password")String password);

    int insert(User record);

    User selectByPrimaryKey(Integer userid);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}