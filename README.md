服务器网址：



http://menghong.fun:8081/shorturl/index







**请求URL：** 

- ` menghong.fun:8081/shorturl/create `

**请求方式：**
- POST 

**参数：** 

| 参数名      | 必选   | 类型     | 说明           |
| :------- | :--- | :----- | ------------ |
| url      | 是    | string | 你需要缩短的密码     |
| password | 是    | int    | 访问该短网址所需要的密码 |
| repeat   | 是    | int    | 确认密码         |
| username | 是    | string | 无            |


**返回示例**

``` 
{ 
     "msg" : "OK", 
     "status" : "200", 
     "data" : { 
          "previousUrl" : "https://blog.yangruixin.com/archives/69", //原网址
          "shortUrl" : "menghong.fun:8081/shorturl/YR77je" 	//缩短后的网址
     } 
 }
```



失败：

``` 
{ 
     "msg" : "两次的密码不同", 
     "status" : "101", 
     "data" : { 
     } 
 }
```


请求URL：

menghong.fun:8081/shorturl/{url}

url为最开始缩短网址返回的字符串

- ` menghong.fun:8081/shorturl/R7nU7f `

**请求方式：**
- POST 

**参数：** 

| 参数名      | 必选   | 类型   | 说明       |
| :------- | :--- | :--- | -------- |
| password | 是    | int  | 最开始设置的密码 |


**返回示例**

``` 
{ 
     "msg" : "OK", 
     "status" : "200", 
     "data" : "https://www.baidu.com/s?wd=soringboot%20%E6%89%93%E5%8C%85jar%20%E9%83%A8%E7%BD%B2%E5%88%B0%E6%9C%8D%E5%8A%A1%E5%99%A8&rsv_spt=1&rsv_iqid=0xba0e0de600033051&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&rqlang=cn&tn=baiduhome_pg&rsv_enter=0&oq=soringboot%2520%25E6%2589%2593%25E5%258C%2585jar%2520%25E9%2583%25A8%25E7%25BD%25B2%25E5%2588%25B0%25E6%259C%258D%25E5%258A%25A1%25E5%258C%25BA&rsv_t=5ed2S4Mar78WswK0IGblXcAEwQ7mpcDlhgYDpeOt2zdaxTziEd4nazbmrdSn1%2BZAhNYw&rsv_pq=d037cc4c0000a516&inputT=1080&rsv_sug3=118&rsv_sug1=69&rsv_sug7=000&rsv_sug2=0&rsv_sug4=1659&rsv_sug=1" //原网址
 }
```




**请求URL：** 

- ` menghong.fun:8081/shorturl//register/vertify `

**请求方式：**
- POST 

**参数：** 

| 参数名      | 必选   | 类型     | 说明   |
| :------- | :--- | :----- | ---- |
| password | 是    | int    | 无    |
| username | 是    | string | 无    |


**返回示例**

``` 
{ 
     "msg" : "OK", 
     "status" : "200", 
     "data" : { 
     } 
 }
```

失败：

``` 
{ 
     "msg" : "该用户名已存在", 
     "status" : "102", 
     "data" : { 
     } 
 }
```




**请求URL：** 

- ` menghong.fun:8081/shorturl//login `

**请求方式：**
- POST 

**参数：** 

| 参数名      | 必选   | 类型     | 说明   |
| :------- | :--- | :----- | ---- |
| password | 是    | int    | 无    |
| username | 是    | string | 无    |


**返回示例**

``` 
{ 
     "msg" : "OK", 
     "status" : "200", 
     "data" : { 
     } 
 }
```
失败：

``` 
{ 
     "msg" : "密码错误", 
     "status" : "104", 
     "data" : { 
     } 
 }
```