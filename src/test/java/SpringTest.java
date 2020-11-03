import com.ssmStudy.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void startSpring(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = (People) ac.getBean("people");
        System.out.println("简单类型输入---》");
        System.out.println("list里注入简单类型："+people.getList().get(0));;
        System.out.println("map里注入简单类型："+people.getMap().get("a"));
        System.out.println("set里注入简单类型,大小："+people.getSet().size());
        System.out.println("map里注入简单类型："+people.getMapPro().get("a"));;
        System.out.println("bean注入---》");
        System.out.println("list里注入bean:"+people.getListForBean().get(0));
        System.out.println("map里注入bean："+people.getMapForBean().get("a"));
        System.out.println("set里注入bean,大小："+people.getSetForBean().size());
        System.out.println("数组里注入bean,大小："+people.getRiceArr().length);

    }

}
