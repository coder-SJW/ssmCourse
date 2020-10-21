import com.ssmStudy.dao.studentMapper2;
import com.ssmStudy.pojo.SchoolRoll;
import com.ssmStudy.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * @Author sjw
 * @Description
 * @Date 16:30 2020/10/10
 **/
public class Test {
    @org.junit.Test
    /**
     *  一对一查询
     */
    public void selectSchoolRoll() throws IOException {
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory;
            factory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = factory.openSession();

            List<SchoolRoll> res = sqlSession.selectList("selectSchoolRoll","1");
            for(SchoolRoll schoolRoll : res){
                System.out.println(schoolRoll);
            }
        } catch (IOException e) {
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    /**
     *  一对多查询
     */
    @org.junit.Test
    public void selectStu() throws IOException {
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory;
            factory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = factory.openSession();
            List<SchoolRoll> res = sqlSession.selectList("selectStuP","史继炜");
            for(SchoolRoll schoolRoll : res){
                System.out.println(schoolRoll);
            }

        } catch (IOException e) {
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 面向接口编程（绑定接口）
     */
    @org.junit.Test
    public void seletStu2() {
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory;
            factory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = factory.openSession();
            SchoolRoll res = sqlSession.getMapper(com.ssmStudy.dao.StudentDao.class).selectSchoolRoll("1");
            System.out.println(res);

        } catch (IOException e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
        /**
         * 对Student表进行批量插入
         */
        @org.junit.Test
        public void insert(){
            InputStream inputStream = null;
            SqlSession sqlSession = null;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                SqlSessionFactory factory;
                factory = new SqlSessionFactoryBuilder().build(inputStream);
                sqlSession = factory.openSession();
                studentMapper2 mapper = sqlSession.getMapper(studentMapper2.class);
                //批量数据装入List
                List<Student> list = new ArrayList<Student>();
                Student stu1 = new Student();
                Student stu2 = new Student();
                stu1.setNumber(String.valueOf(UUID.randomUUID()));
                stu1.setName("张三");
                stu1.setSex("男");
                stu1.setGrade("大二");
                stu1.setAge(16);
                stu2.setNumber(String.valueOf(UUID.randomUUID()));
                stu2.setName("李四");
                stu2.setSex("男");
                stu2.setGrade("大二");
                stu2.setAge(16);
                list.add(stu1);
                list.add(stu2);
                int res = mapper.insertStu(list);
                sqlSession.commit();
            } catch (Exception e) {
                sqlSession.rollback();
                e.printStackTrace();
            }finally {
                if(sqlSession != null) {
                    sqlSession.close();
                }
            }
        }
}
