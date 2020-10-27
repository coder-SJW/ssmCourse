import com.ssmStudy.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void startSpring(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = (People) ac.getBean("people");
        people.eat();
    }
}
