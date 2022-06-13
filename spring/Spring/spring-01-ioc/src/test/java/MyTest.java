import com.li.pojo.hello;
import com.li.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {

        // 获取spring的上下文对象，拿到spring的容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // 我们的对象都在spring中的管理，我们要使用，直接从里面取出来就行
        hello hllo =(hello) context.getBean("hel");
        System.out.println(hllo.toString());

        UserServiceImpl userservice = (UserServiceImpl) context.getBean("Userservice");
        userservice.getUser();
    }
}
