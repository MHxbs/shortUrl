package team.redrock.shorturl1.service;

public interface UserService {

    boolean isExist(String username);

    boolean passwordIsRight(String username,String password);

    int insertOneUser(String username,String password);

}
