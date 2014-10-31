import com.tpg.spring.intro.entities.User;
import com.tpg.spring.intro.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService = applicationContext.getBean(UserService.class);

        User user = userService.get(1); // Ana

        userService.save(user, 1);      // Ana
    }
}
