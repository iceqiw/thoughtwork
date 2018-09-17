##设计

###问题分析

已知条件

1.ABCDE 5个车站

2.AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7 8条线路

问题归纳：

问题类别1：问题1到5为一类问题，计算制定路线距离 。

问题类别2：问题6-10 为一类问题，限定条件下的路线规划。


###主要设计

domain  包含路线，车站，策略参数，旅行路线。

Strategy 路线规划策略

RailRoadServiceFactory 路线服务工厂，提供初始化路线图的功能，生成各种服务功能。

service 为旅客提供的各种路线服务

exception 提供路线无法找到的异常

Application 主入口程序
##  解决方案

关于问题类别1：查询对应路线距离相加
关于问题类别2：通过实现不同的策略，完成路线统计，输出。

###策略

1.根据站点计算旅行距离策略

2.停靠站为限制条件策略

3.不重复路线为限制条件策略

4.最远距离为限制条件策略


###服务

根据制定停靠站获取旅行距离服务:策略1

根据停靠站获取获取路线信息服务:策略2

 获取路途最短流程距离服务：策略3
 
 根据最远距离获取路途线路信息服务：策略4
 
 ## 运行
 
 1.运行maven 命令
 
 mvn  clean package
 
 2.在${project_path}/target目录下（project_path 为项目对应路径）运行ThoughtWorksHomeTest-1.0-SNAPSHOT.jar包

java -jar ThoughtWorksHomeTest-1.0-SNAPSHOT.jar 

3.运行程序后出现：please input GraphFile path：

     输入文件路径：datafilepath


4.输出样例：

please input graph file path：D:\workspace\java\thoughtwork\data.txt


Graph:AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7

Output:

Output #1:9

Output #2:5

Output #3:13

Output #4:22

Output #5:NO SUCH ROUTE

Output #6:2

Output #7:3

Output #8:9

Output #9:9

Output #10:7