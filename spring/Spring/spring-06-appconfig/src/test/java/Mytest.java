import com.li.config.myconfig;
import com.li.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mytest {
    public static void main(String[] args) {
        // 如果完全使用配置类操作，我们就只能 使用AnnotationConfigApplicationContext，获取上下文，通过配置类的class对象加载
        ApplicationContext context = new AnnotationConfigApplicationContext(myconfig.class);
        User getUser = (User) context.getBean("getUser");
        System.out.println(getUser.getName());
    }
}
