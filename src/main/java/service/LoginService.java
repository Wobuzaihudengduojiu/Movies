package service;

import pojo.VO.UserVO;
import pojo.entity.User;

import javax.servlet.http.HttpSession;

public interface LoginService {

    boolean login(String email, String password);

    UserVO getUserInfo();

    boolean loginOut();

}
