import com.ssmStudy.pojo.SchoolRoll;
import com.ssmStudy.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author sjw
 * @Description mybatis总结类
 * @Date 8:54 2020/10/20
 **/
public class Zhongjie {
    @Test
    public void selectStu(){
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory;
            factory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = factory.openSession();
            List<Student> stu = sqlSession.selectList("selectStu","史继炜");
            for(Student res : stu){
                System.out.println(res);
            }


        } catch (IOException e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
