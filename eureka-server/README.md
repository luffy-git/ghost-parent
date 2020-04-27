# eureka-server

#### 介绍
** 这是一个 Spring Cloud  集成案例应用 **

[Eureka 高可用集群案例](https://gitee.com/code_luffy/ghost-parent/tree/master/eureka-server)

#### 软件架构
1.  在实际部署通过不同服务器的 domain 或者内网 ip 来区分每个节点
2.  为了测试集群,当前案例通过修改本地 [hosts](https://jingyan.baidu.com/article/9113f81b49ed2f2b3214c7fa.html) 文件模拟多节点

#### 如果编辑器使用的是 idea 的话,配置三个应用打包,然后一起运行.安装教程

1.  添加运行配置  
![输入图片说明](https://images.gitee.com/uploads/images/2020/0325/013550_a56bb814_968600.png "添加运行配置")
2.  添加一个 springboot run 配置  
![输入图片说明](https://images.gitee.com/uploads/images/2020/0325/013605_a9489256_968600.png "添加一个 springboot run 配置")
3.  配置 springboot run 的Main方法和运行参数以及运行代码模块
![输入图片说明](https://images.gitee.com/uploads/images/2020/0325/013626_ac14ee9b_968600.png "配置 springboot run 的Main方法和运行参数以及运行代码模块")
4.  配置一个运行模组  
![输入图片说明](https://images.gitee.com/uploads/images/2020/0325/013638_bed410f9_968600.png "配置一个运行模组")
5.  将应用添加到配置模组中
![输入图片说明](https://images.gitee.com/uploads/images/2020/0325/013658_10c55bab_968600.png "将应用添加到配置模组中")
6.  集群中需要几个节点运行,则复制几个运行配置.并修改对应的JVM参数,再重复第5步,将应用都添加到一个运行模组
![输入图片说明](https://images.gitee.com/uploads/images/2020/0325/014659_1b83e8e4_968600.png "集群中需要几个节点运行,则复制几个运行配置.并修改对应的JVM参数,再重复第5步,将应用都添加到一个运行模组")
7.  最终效果
![输入图片说明](https://images.gitee.com/uploads/images/2020/0325/013942_fe86b2ab_968600.png "最终效果")
8. 直接运行整个配置模组,则会将模组内所有应用全部 run 起来,再去 eureka 控制台查看效果
![输入图片说明](https://images.gitee.com/uploads/images/2020/0325/014754_5b834954_968600.png "直接运行整个配置模组,则会将模组内所有应用全部 run 起来,再去 eureka 控制台查看效果")


#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 码云特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5.  码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
