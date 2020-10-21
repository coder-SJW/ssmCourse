
import com.ssmStudy.dao.StudentDao;
import com.ssmStudy.pojo.SchoolRoll;
import com.ssmStudy.pojo.Student;
import com.ssmStudy.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @Author sjw
 * @Description mybatis相关测试
 * @Date 17:25 2020/9/10
 **/
public class mybatis {
    @Test
    public void selectStu() throws IOException {
        Logger logger = Logger.getLogger(mybatis.class);
        //获取mybatis配置文件流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //通过配置文件流创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSeesion = factory.openSession();
        //通过SqlSession执行方法（sql）
        List<Map> list = sqlSeesion.selectList("selectStu");
        //数据检验
        for (Map map : list) {
            logger.debug(map);
        }
        //关闭当前Sqlsession
        sqlSeesion.close();
    }

    /**
     * 带条件查询（一个条件）
     */
    @Test
    public void selectStu2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSeesion = factory.openSession();
        List<Map> list = sqlSeesion.selectList("selectStu2", "刘德华");
        //关闭当前Sqlsession
        sqlSeesion.close();
    }

    /**
     * 带条件查询（多条件，map传值）
     */
    @Test
    public void selectStu3() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSeesion = factory.openSession();
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "史继炜");
        params.put("grade", "大三");
        List<Map> list = sqlSeesion.selectList("selectStu3", params);
        sqlSeesion.close();
    }

    /**
     * 带条件查询（多条件，自定义类型传值）
     */
    @Test
    public void selectStu4() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSeesion = factory.openSession();
        Student stu = new Student();
        stu.setName("史继炜");
        stu.setGrade("大三");
        List<Student> list = sqlSeesion.selectList("selectStu4", stu);
        sqlSeesion.close();
    }

    /**
     * 增加数据（参数传pojo对象）
     */
    @Test
    public void addStu() {
        InputStream inputStream = null;
        SqlSession sqlSeesion = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSeesion = factory.openSession();
            Student stu = new Student();
            //UUID.randomUUID().toString();
            stu.setNumber("7");
            stu.setName("刘德华");
            stu.setAge(18);
            stu.setSex("男");
            stu.setGrade("大一");
            int res = sqlSeesion.insert("addStu", stu);
            //需了解它的缓存机制:mybatis默认每次获取session都会开启一个事务，且不自动提交事务。如果更新操作完成后不手动commit，则在连接断开时会将更新操作回滚。
            sqlSeesion.commit();
        } catch (IOException e) {
            sqlSeesion.rollback();
            e.printStackTrace();
        } finally {
            if (sqlSeesion != null) {
                sqlSeesion.close();
            }
        }
    }
    /**
     * 删除数据（参数传pojo对象）
     */
    @Test
    public void deleteStu(){
        InputStream inputStream = null;
        SqlSession sqlSeesion = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSeesion = factory.openSession();
            Student stu = new Student();
            //UUID.randomUUID().toString();
            stu.setNumber("7");
            int res = sqlSeesion.delete("deleteStu", stu);
            //需了解它的缓存机制:mybatis默认每次获取session都会开启一个事务，且不自动提交事务。如果更新操作完成后不手动commit，则在连接断开时会将更新操作回滚。
            sqlSeesion.commit();
        } catch (IOException e) {
            sqlSeesion.rollback();
            e.printStackTrace();
        }finally {
            if(sqlSeesion != null) {
                sqlSeesion.close();
            }
        }
    }
    /**
     * 修改数据（参数传pojo对象）
     */
    @Test
    public void updateStu(){
        InputStream inputStream = null;
        SqlSession sqlSeesion = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSeesion = factory.openSession();
            Student stu = new Student();
            //UUID.randomUUID().toString();
            stu.setNumber("7");
            stu.setName("刘德华");
            stu.setAge(18);
            stu.setSex("女");
            stu.setGrade("大一");
            int res = sqlSeesion.update("updateStu", stu);
            //需了解它的缓存机制:mybatis默认每次获取session都会开启一个事务，且不自动提交事务。如果更新操作完成后不手动commit，则在连接断开时会将更新操作回滚。
            sqlSeesion.commit();
        } catch (IOException e) {
            sqlSeesion.rollback();
            e.printStackTrace();
        }finally {
            if(sqlSeesion != null) {
                sqlSeesion.close();
            }
        }
    }
    /**
     * 查询数据（参数传pojo对象）
     */
    @Test
    public void selectStu_(){
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = factory.openSession();
            Student stu = new Student();
            //UUID.randomUUID().toString();
            stu.setNumber("7");
            List<Student> res = sqlSession.selectList("selectStu_",stu);
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
     * 查询数据（resultMap）
     */
    @Test
    public void selectTeacher(){
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = factory.openSession();
            Teacher teacher = new Teacher();
            teacher.setTeacherId("1");
            teacher.setTeacherName("史泰龙");
            List<Teacher> res = sqlSession.selectList("selectTeacher",teacher);
            for(Teacher teacher1 : res){
                System.out.println(teacher1);
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

}
