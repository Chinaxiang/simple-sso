# SSO 极简实现

Single Sign On（以下简称SSO），是指在多系统应用群中登录一个系统，便可在其他所有系统中得到授权而无需再次登录，包括单点登录与单点注销两部分。

## 登录

sso需要一个独立的认证中心，只有认证中心能接受用户的用户名密码等安全信息，其他系统不提供登录入口，只接受认证中心的间接授权。间接授权通过令牌实现，sso认证中心验证用户的用户名密码没问题，创建授权令牌，在接下来的跳转过程中，授权令牌作为参数发送给各个子系统，子系统拿到令牌，即得到了授权，可以借此创建局部会话，局部会话登录方式与单系统的登录方式相同。

![](http://ww1.sinaimg.cn/large/937a8a41ly1g04lv06lpdj20kh0pv75y.jpg)

## 注销

单点登录自然也要单点注销，在一个子系统中注销，所有子系统的会话都将被销毁。

![](http://ww1.sinaimg.cn/large/937a8a41ly1g04m0r6esqj20je0dvwf3.jpg)

## 部署及测试

1. 下载或克隆本项目到本地目录
2. 切到项目根路径双击compile.bat选择compile编译项目
3. 将3个项目target中的sso-server.war,sso-subsysa.war,sso-subsysb.war三个包放置到tomcat的webapps下，并将sso-server.war改名为ROOT.war
4. 启动tomcat
5. 配置本机hosts, 添加 `127.0.0.1 sso.com`配置
6. 浏览器访问 http://sso.com:8080/sso-subsysa/test
7. 跳转到http://sso.com:8080/?clientUrl=http://sso.com:8080/sso-subsysa/test ,点击登录
8. 浏览器新页面访问 http://sso.com:8080/sso-subsysb/test
9. 在subsysa或者subsysb页面点击Logout, 再刷新另外一个页面

## 其他说明

- 不通过compile.bat请自行使用mvn命令编译打包
- suba,subb项目的web.xml中配置的sso-server的地址为http://sso.com:8080, 所以需要配置hosts
- 原理详细介绍请移步：http://huangyanxiang.com/2019/01/12/sso.html

