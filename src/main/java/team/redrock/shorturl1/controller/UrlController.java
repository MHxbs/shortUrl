package team.redrock.shorturl1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import team.redrock.shorturl1.domain.Result;
import team.redrock.shorturl1.domain.ResultEnum;
import team.redrock.shorturl1.service.ShortUrlService;
import team.redrock.shorturl1.util.ResultUtil;
import team.redrock.shorturl1.util.ShortUrlUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@Controller
public class UrlController {

    @Autowired
    private ShortUrlService shortUrlService;

  /*  @GetMapping(value = "/login")
    public String login(){
        return "login";
    }*/

    @GetMapping(value = "/short")
    public String index() {
        return "short";
    }

    @GetMapping(value = "/password")
    public String password(){
        return "password";
    }

    @PostMapping(value = "/create")
    @ResponseBody
    public Result createShortUrl(@RequestParam("url") String url,
                                @RequestParam("password") String password,
                                 @RequestParam("repeat") String repeat,
                                 @RequestParam("username") String username){


        return shortUrlService.createOneShortUrl(url,password,repeat,username);
    }


    @PostMapping(value = "/{shortUrl}")
    @ResponseBody
    public Result reSent(HttpServletResponse response, @PathVariable("shortUrl") String shortUrl
            , HttpServletRequest request){

        String password=request.getParameter("password");
        if (shortUrlService.passwordIsRight(shortUrl,password)) {
            String previousUrl = shortUrlService.findPreviousUrl(shortUrl);
            return ResultUtil.success(previousUrl);
        }else {
            return ResultUtil.error(ResultEnum.PASSWORDWRONG);
        }
    }

}
