package service.impl;

import dao.UserMapper;
import enmu.ErrorEnum;
import exception.MoviesException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pojo.VO.UserVO;
import pojo.entity.User;
import service.LoginService;
import sun.security.provider.MD5;
import util.Constants;
import util.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String email, String password) {
//        password = DigestUtils.md5DigestAsHex(password.getBytes());
        User user = userMapper.login(email, password);
        if (user == null) {
            throw new MoviesException(ErrorEnum.E_301);
        }
        UserVO userVO = new UserVO();
        System.out.println(user);
        BeanUtils.copyProperties(user, userVO);
        Utils.getRequest().getSession().setAttribute(Constants.SESSION_USER_INFO, userVO);
        return true;
    }

    @Override
    public UserVO getUserInfo() {
        Object o = Utils.getRequest().getSession().getAttribute(Constants.SESSION_USER_INFO);
        System.out.println(o);
        if (o != null) {
            return (UserVO) o;
        }
        return null;
    }

    @Override
    public boolean loginOut() {
        Utils.getRequest().getSession().invalidate();
        return true;
    }
}
