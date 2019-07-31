package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.VO.UserVO;
import pojo.entity.User;
import service.LoginService;

@RestController
public class LoginController {


    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public boolean login(@RequestParam String email,
                        @RequestParam String password){
        return loginService.login(email,password);
    }

    @GetMapping("/getUserInfo")
    public UserVO getUserInfo(){
        return loginService.getUserInfo();
    }

    @GetMapping("/loginOut")
    public boolean loginOut(){
        return loginService.loginOut();
    }
}
