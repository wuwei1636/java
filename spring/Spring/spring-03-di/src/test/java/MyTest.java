import com.li.pojo.Student;
import com.li.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Student studdent = (Student) context.getBean("studeng");
        System.out.println(studdent.toString());

        //运行结果
        //Student{name='李坤松',
        // address=Address{address='河南省郑州市登封市'},
        // books=[红楼梦, 西游记, 水浒传, 三国演义],
        // hobbys=[听歌, 看电影],
        // card={身份证=123456, 银行卡=123fasdf},
        // games=[LOL, COC],
        // wife='null',
        // info={学号=123123123, 姓名=李坤松}}
    }


    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = (User) context.getBean("user2");
        System.out.println(user);
    }
}
