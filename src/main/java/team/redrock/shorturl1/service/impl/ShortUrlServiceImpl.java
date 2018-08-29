package team.redrock.shorturl1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import team.redrock.shorturl1.domain.Result;
import team.redrock.shorturl1.domain.ResultEnum;
import team.redrock.shorturl1.domain.TwoUrl;
import team.redrock.shorturl1.entity.IdToUrl;
import team.redrock.shorturl1.entity.UserToId;
import team.redrock.shorturl1.mapper.UrlMapper;
import team.redrock.shorturl1.mapper.UserMapper;
import team.redrock.shorturl1.service.ShortUrlService;
import team.redrock.shorturl1.util.ResultUtil;
import team.redrock.shorturl1.util.ShortUrlUtil;

import javax.validation.Valid;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    @Value("${shortUrl}")
    private String shortUrlStr;


    @Autowired
    private UrlMapper urlMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean isExistURL(String id) {
        if (urlMapper.selectById(id)==null){
            return false;
        }else {
            return true;
        }

    }

    @Override
    public Result createOneShortUrl(String url,String password,String repeat,String username) {
        if (!url.startsWith("http://") && !url.startsWith("https://")){
            return ResultUtil.error(ResultEnum.URlERRO);
        }
        if (!password.equals(repeat)){
            return ResultUtil.error(ResultEnum.PASSWORDERRO);
        }
        int amount=userMapper.selectAmoutOfUrl(username).size();
        int limit=userMapper.selectOneByUsername(username).getLimits();
        if (amount>=limit){
            return ResultUtil.error(ResultEnum.LIMIT);
        }
        String [] shortUrls= ShortUrlUtil.ShortText(url);
        String id=shortUrls[0];

        if (!isExistURL(id)){
            IdToUrl idToUrl=new IdToUrl();
            idToUrl.setUrl(url);
            idToUrl.setId(id);
            idToUrl.setPassword(password);
            urlMapper.insertOne(idToUrl);
            UserToId userToId=new UserToId();
            userToId.setId(id);
            userToId.setUsername(username);
            userMapper.insertUser_ID(userToId);
        }else {
            return ResultUtil.error(ResultEnum.URLEXIST);
        }
        TwoUrl twoUrl=new TwoUrl();
        twoUrl.setPreviousUrl(url);
        twoUrl.setShortUrl(shortUrlStr+id);
        return ResultUtil.success(twoUrl);
    }

    @Override
    public String findPreviousUrl(String shortUrl) {
       // String id=shortUrl.substring(shortUrl.indexOf(shortUrlStr));

        return urlMapper.selectById(shortUrl).getUrl();
    }

    @Override
    public boolean passwordIsRight(String id, String password) {
        IdToUrl idToUrl=urlMapper.selectById(id);
        if (idToUrl.getPassword().equals(password)){
            return true;
        }else {
            return false;
        }
    }
}
