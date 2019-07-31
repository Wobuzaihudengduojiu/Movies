package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import pojo.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

<<<<<<< HEAD
=======
    User login(@Param("email") String email,@Param("password")String password);

>>>>>>> 85c1e1886c6bbd026b6dbf5089741a88bdd58139
    int insert(User record);

    User selectByPrimaryKey(Integer userid);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}