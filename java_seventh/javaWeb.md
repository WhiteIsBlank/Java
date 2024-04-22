# javaWeb

**简介**：全球广域网，即万维网（www）

**B/S架构**：Browser/Server，浏览器/服务器架构模式

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/d38cf518-f9f8-4d06-8988-d0c1e127ef48)

## HTTP

超文本传输协议，规定了浏览器和服务器之间数据传输的规则

##### HTTP协议特点

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/10d845de-c020-492d-aa44-47a8fa900885)

##### HTTP请求数据格式

###### 数据3部分

1.请求行：请求数据的第一行。其中GT表示请求方式，/表示请求资源路径，HTTP/1.1表示协议版本
2.请求头：第二行开始，格式为key:value形式
3.请求体：POST请求的最后一部分，存放请求参数

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/c4b95b5b-180a-4c0d-bdb0-0b37981d0f8a)

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/e44dea55-cab3-48a2-b59c-eea62332c8a4)

###### 常见HTTP请求头

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/696ebc16-55ba-4e58-9d84-3a3e6568ed68)

###### GET请求和POST请求区别：

1.GET请求请求参数在请求行中，没有请求体。POST请求请求参数在请求体中
2.GET请求请求参数大小有限制，POST没有

##### HTTP响应数据格式

###### 响应数据格式

1.响应行：响应数据的第一行。其中HTTP/1.1表示协议版本，200表示响应状态码，OK表示状态码描述
2.响应头：第二行开始，格式为key:value形式
3.响应体：最后一部分。存放响应数据

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/f32047ea-4c80-4c0b-a329-b2cbb669a707)

###### 常见HTTP响应头

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/66d05929-c074-43ea-b59f-60b58b8f7b70)

[]: https://cloud.tencent.com/developer/chapter/13553	"常见状态码"

## Web服务器

Web服务器是一个应用程序，对HTTP协议的操作进行封装。

##### Tomcat

###### 基本使用

- 配置

1.修改启动端口号：conf/server.xml

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/9ca7daf4-9926-493e-8db4-58e196654e68)

注：HTTP协议默认端口号为80，如果修改Tomcat的端口号为80，再次访问Tomcat的时候，不需要输入 端口号

- 启动时可能出现的问题

1.端口号冲突：关掉即可

2.启东市窗口闪过：检查JAVA_HOME环境变量是否正确配置

###### 部署项目

- 部署项目

将项目放置到webapps目录下，即部署完成

- 一般javaWeb项目会被打成war包，然后将war包放到webapps目录下

###### Maven Web项目

项目结构

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/b0fb689f-100d-4c75-b331-ad545422d885)

**IDEA集成本地Tomcat**

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/9e4a026b-54a8-41df-ad4a-27d933eb615a)

**IDEA使用Tomcat Maven插件**

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/4cde9349-1a5d-46a4-b2e2-6e20c53d3f10)

## Servlet

Servlet是Java提供的一门动态Web资源开发技术

##### servlet基本使用步骤

###### 配置访问路径

```java
//配置访问路径
@WebServlet("/demo1")

@WebServlet(urlPatterns="/demo",loadOnStartup=1);//默认是-1，如果是1在服务器启动的时候就创建Servlet对象
```

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/1e1fc3ab-6128-4720-a47e-6ecb00e9d877)

```java
	/*
	提供服务的方法
	1.调用时机：每一次Servlet被访问
	2.调用次数：访问的时候
	*/
	@Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet hello world");
    }
	/*
	初始化方法
	1.调用时机：默认情况下Servlet第一次被访问的时候，调用
	2.调用次数：1
	*/
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
		
    }
	/*
	获取ServletConfig对象
	*/
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
	/*
	获取Servlet信息
	*/
    @Override
    public String getServletInfo() {
        return null;
    }
	/*
	销毁方法
	1.调用时机：内存释放或者服务器关闭，Servlet对象会被销毁
	2.调用次数：
	*/
    @Override
    public void destroy() {

    }
```

##### Servlet体系结构

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/dad309ba-3bbb-4bde-8a73-3c13b9f082d9)

浏览器直接使用URL的方式来访问资源是用的GET请求的方式

##### Servlet urlPattern配置

- 一个Servlet可以配置多个访问路径

```java
@WebServlet(urlPatterns = {"/demo2","/demo3"})
```

- urlPattern配置规则

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/dc8b1bfb-52c0-4cba-8887-e165a394ef22)

## Request & Response

##### Request继承体系

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/12bf76fe-3837-4683-bf5b-5bdabfd319d8)

##### Request获取请求数据

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/6055905e-b9ee-4c2d-af35-181976ed65b0)

```java
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException, ServletException {
        //请求行
        //String getMethod():获取请求方式：GET
        String method=req.getMethod();
        System.out.println(method);//GET
        //String getContextPath():获取虚拟目录（项目访问路径）：/Tomcat_war
        String contextPath=req.getContextPath();
        System.out.println(contextPath);
        //StringBuffer getRequestURL():获URL(统资源定位符)：http://localhost:8080/Tomcat_war/demo2
        StringBuffer url=req.getRequestURL();
        System.out.println(url.toString());
        //String getRequestURI():获取URI(统一资源标识)：/Tomcat_war/demo2
        String uri= req.getRequestURI();
        System.out.println(uri);
        //String getQuerystring():获取请求参数(GET方式)：username=zhangsan
        String querystring=req.getQueryString();
        System.out.println(querystring);
        //请求头
        String header = req.getHeader("user-agent");
        System.out.println(header);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求体
        //1.获取字符输入流
        BufferedReader br =req.getReader();
        //2.读取数据
        String line = br.readLine();;
        System.out.println(line);
    }
```

