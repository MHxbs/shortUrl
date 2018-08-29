package team.redrock.shorturl1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.redrock.shorturl1.domain.Result;
import team.redrock.shorturl1.domain.ResultEnum;
import team.redrock.shorturl1.service.impl.UserServiceImpl;
import team.redrock.shorturl1.util.ResultUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/index")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/register")
    public String register(){
        return "register";
    }

    @PostMapping(value = "/register/vertify")
    @ResponseBody
    public Result vertify(@RequestParam("username") String username,
                          @RequestParam("password") String password){

        if (userService.isExist(username)){
            return ResultUtil.error(ResultEnum.USEREXIST);
        }else {
            userService.insertOneUser(username,password);
            return ResultUtil.success();
        }

    }


    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(@RequestParam("username") String username,
                        @RequestParam("password") String password){


        if (!userService.isExist(username)){
            return ResultUtil.error(ResultEnum.USEREMPTY);
        }

        if (userService.passwordIsRight(username,password)){
           return ResultUtil.success();
        }else {
            return ResultUtil.error(ResultEnum.PASSWORDWRONG);
        }


    }

}
