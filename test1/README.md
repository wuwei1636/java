# springboot 整合  springsecurity 

[demo代码](https://github.com/wuwei1636/java)

[狂神说的springboot整合springsecurity（没有使用数据库）](https://cloud.tencent.com/developer/article/1674681#:~:text=Spring%20Security%20%E6%98%AF%E9%92%88%E5%AF%B9%20Spring%20%E9%A1%B9%E7%9B%AE%E7%9A%84%E5%AE%89%E5%85%A8%E6%A1%86%E6%9E%B6%EF%BC%8C%E4%B9%9F%E6%98%AF,Spring%20Boot%20%E5%BA%95%E5%B1%82%E5%AE%89%E5%85%A8%E6%A8%A1%E5%9D%97%E9%BB%98%E8%AE%A4%E7%9A%84%E6%8A%80%E6%9C%AF%E9%80%89%E5%9E%8B%EF%BC%8C%E5%AE%83%E5%8F%AF%E4%BB%A5%E5%AE%9E%E7%8E%B0%E5%BC%BA%E5%A4%A7%E7%9A%84%E5%BA%94%E7%94%A8%E5%AE%89%E5%85%A8%E6%8E%A7%E5%88%B6%EF%BC%8C%E6%88%91%E4%BB%AC%E5%8F%AA%E9%9C%80%E5%BC%95%E5%85%A5%20spring-boot-starter-security%20%E6%A8%A1%E5%9D%97%EF%BC%8C%E5%86%8D%E8%BF%9B%E8%A1%8C%E5%B0%91%E9%87%8F%E7%9A%84%E9%85%8D%E7%BD%AE%EF%BC%8C%E5%8D%B3%E5%8F%AF%E5%AE%9E%E7%8E%B0%E5%BC%BA%E5%A4%A7%E7%9A%84%E5%AE%89%E5%85%A8%E7%AE%A1%E7%90%86%E3%80%82)

**SpringSecurity的核心功能：**

- **用户认证（Authentication）：系统判断用户是否能登录**
- **用户授权（Authorization）：系统判断用户是否有权限去做某些事情**

## 导入依赖

```xml
<!--springsecurity的依赖 和 thymeleaf对springsecurity的依赖-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>org.thymeleaf.extras</groupId>
    <artifactId>thymeleaf-extras-springsecurity5</artifactId>
</dependency>
```



## 配置Mybatis

```properties
# 数据库驱动：
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
# 数据源名称
spring.datasource.name=defaultDataSource
# 数据库连接地址
spring.datasource.url=jdbc:mysql://localhost:3306/myself?serverTimezone=UTC
# 数据库用户名&密码：
spring.datasource.username= root
spring.datasource.password= 123456
#下面这些内容是为了让MyBatis映射
#指定Mybatis的Mapper文件
mybatis.mapper-locations=classpath:mybatis/mapper/*xml
#指定Mybatis的实体目录
mybatis.type-aliases-package=com.li.pojo
# 应用服务 WEB 访问端口
```

## 数据库的设计

![image-20220918200703517](D:/Notepadpp/typora%20%20img/image-20220918200703517.png)

## SpringSecurity 分析

### 自定义SpringSecurity

自定义springsecurity需要先创建一个 **SecurityConfig的类** 继承 `WebSecurityConfigurerAdapter`，

```java
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    //  密码加密 springsecurity 必须进行密码加密
    @Bean
    public PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }

    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 登录
        http.formLogin() 
                .loginPage("/login")  // 自定义登录的界面
                .defaultSuccessUrl("/hello").permitAll()
                .and().csrf().disable();

        // 设置访问权限
        http.authorizeRequests()
            	// 这里的权限验证不需要 添加  'ROLE_'
                .antMatchers("/hello1").hasRole("vip1")  // 只有 vip1的用户才可以访问 /hello1 的请求
                .antMatchers("/","/user/login","/user/register","/register").permitAll();  // 所有人都可以访问的请求
                     
        // 所有请求都必须经过认证才能访问，必须登录
        http.authorizeRequests()
                .anyRequest().authenticated();

        // 遇到没有权限访问跳转的界面
        http.exceptionHandling().accessDeniedPage("/uncheck");

    }

    // 忽略拦截，对静态资源所需的js，css等不设置拦截
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/**/*.js","/**/*.css","/**/*.jpg");
    }
}
```



### 实现登录验证

使用UserDetailsService 接口从数据库中获取信息，实现登录验证功能

```java
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        // 使用已经编辑好的 usermapper 进行数据库的查询操作
        com.li.pojo.User  user = userMapper.getUserByName(username);

        System.out.println(user);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
		
        // springsecurity 对role 有规定，前缀需要有一个 ROLE_ , 否则无法实现权限的验证
        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_"+user.getRole());
        
        // 构建security的 User 对象
        return new User(user.getUsername(),new BCryptPasswordEncoder().encode(user.getPassword()),auth);

    }
}

```

## 编辑controller

```java
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    // 登录后的第一个界面
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg1","输出");
        return "view/hello";
    }

    // 登录
    @RequestMapping({"/login","/"})
    public String login(){
        return "view/login";
    }

    // 注册
    @RequestMapping("/user/register")
    public String register(User user, String pwd2, Model model){
        System.out.println(pwd2);
        if(user.getPassword().equals(pwd2)){
            userService.addUser(user);
            System.out.println("注册成功");
        }
        else model.addAttribute("msg","请输入完整的账号密码");
        return "redirect:view/login";
    }

    // vip1 才能访问
    @RequestMapping("/hello1")
    public String hello1(){
        return "view/hello1";
    }

    // 没有权限访问
    @RequestMapping("/uncheck")
    public String uncheck(){
        return "view/403";
    }

}
```

