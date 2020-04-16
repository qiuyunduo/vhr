### 项目介绍

本项目是我跟着江南一点雨的视频做的一个前后端分离的人力资源管理系统，项目采用 SpringBoot+Vue 开发，项目加入常见的企业级应用所涉及到的技术点，例如 Redis、RabbitMQ 等。（末尾附有原作者的github地址）

### 项目技术栈

#### 后端技术栈

1. Spring Boot
2. Spring Security
3. Mybatis
4. MySql
5. Redis
6. RabbitMq
7. Spring Cache
8. WebSocket
9. ...

#### 前端技术栈

1. Vue
2. Element
3. axios
4. vue-router
5. vuex
6. websocket
7. ...

### 项目截图

项目进行了权限管理，前端体现在不同的角色有不同的系统菜单，下面是完整的菜单：

![main](./img/vhr-home.png 'vhr-home')

不同用户登录上来有差异，如下：

![main](./img/vhr-otherRole.png 'vhr-otherRole')

每个用户的角色可由系统管理员进行分配，分配角色页面如下：

![main](./img/vhr-hrMang.png 'vhr-hrMang')

系统角色对应的资源可由系统管理元分配，为角色分配资源页面如下：

![main](./img/vhr-permissMang.png 'vhr-permission')

在线管理员可进行想在线聊天，聊天页面:

![vhr-chat](./img/vhr-chat.png 'vhr-chat')



其他的一些详细页面截图，放在wiki中，点击访问：

1. [员工管理](http://baidu.com "员工管理')
2. [工资套账](http://baidu.com "工资套账')
3. [员工账套](http://baidu.com "员工账套')
4. [部门管理](http://baidu.com "部门管理')
5. [职位管理](http://baidu.com "职位管理')
6. [职称管理](http://baidu.com "职称管理')
7. [权限管理](http://baidu.com "权限管理')
8. [操作员管理](http://baidu.com "操作员管理')
9. [在线聊天](http://baidu.com "在线聊天')

### 总结

这个项目是跟着江南一点雨的视频一行代码一行代码敲出来的，除了一些有开发工具生成出来的代码其他全部跟着纯手敲，前端代码也一样。通过这次项目开发首先对于Springboot认识更深刻，并且对于spring Security也有了很好的理解。对于数据库的多表查询也学到了很多。

### 参考

江南一点雨（项目原作者）: [https://github.com/lenve/vhr](https://github.com/lenve/vhr "微人事项目")



