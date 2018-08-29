package team.redrock.shorturl1.domain;


public enum ResultEnum {
    SUCCESS(200,"成功"),SERVERERRO(500,"服务器错误"),
    URlERRO(100,"url必须以http:// 或https:// 开头"),PASSWORDERRO(101,"两次的密码不同"),
    PASSWORDEMPTY(102,"需要输入密码"),USEREXIST(102,"该用户名已存在"),
    USEREMPTY(103,"用户名不存在"),PASSWORDWRONG(104,"密码错误"),
    LIMIT(104,"您的限制数已经达到"),URLEXIST(106,"url已经缩短");

    private final int status;
    private final String msg;

    ResultEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
