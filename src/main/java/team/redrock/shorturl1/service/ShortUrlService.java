package team.redrock.shorturl1.service;

import team.redrock.shorturl1.domain.Result;

public interface ShortUrlService {

    boolean isExistURL(String id);

    Result createOneShortUrl(String url,String password,String repeat,String username);

    String findPreviousUrl(String shortUrl);

    boolean passwordIsRight(String id,String password);
}
