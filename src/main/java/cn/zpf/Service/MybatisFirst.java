package cn.zpf.Service;

import cn.zpf.dao.ActorDao;
import cn.zpf.dao.impl.ActorDaoImpl;
import cn.zpf.dto.Actor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * Created by LoseMyself on 2017/3/1.
 */
public class MybatisFirst {

    @Test
    // 单条查询
    public void findUserByIdTest() throws IOException {

        String resource = "Mybatis/sqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // selectOne查询单条指定数据
        Actor actor = sqlSession.selectOne("cn.zpf.mapper.UserMapper.findActorById","1");
        System.out.println(actor.toString());
        sqlSession.close();
    }

    @Test
    public void findActorDto() throws IOException{

        String resource = "sqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // selectOne查询单条指定数据

        Actor actor = new Actor().setFirstName("111");
        List<Actor> act = sqlSession.selectList("cn.zpf.mapper.UserMapper.findActorDto",actor);
        System.out.println(act.toString());
        sqlSession.close();

    }

    @Test
    // 多条查询
    public void findActorByName() throws IOException {
        String resource = "sqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // selectList查询多条记录
        List<Actor> actor = sqlSession.selectList("cn.zpf.mapper.UserMapper.findActorByName","111");
        System.out.println(actor.toString());
        sqlSession.close();
    }

    @Test
    // 插入数据
    public void insertActor() throws IOException {
        String resource = "sqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Actor actor = new Actor();
        actor.setFirstName("郑");
        actor.setLastName("鹏飞");
        // selectList查询多条记录
        int result = sqlSession.insert("cn.zpf.mapper.UserMapper.insertActor",actor);
        // 不要忘记将暂存sqlSession的事务提交
        if(result != 0){
            sqlSession.commit();
        }
        System.out.println(actor.getActorId());
        sqlSession.close();
    }

    @Test
    // 删除数据
    public void myDelete() throws IOException {
        String resource = "sqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // selectList查询多条记录
        int result =  sqlSession.delete("cn.zpf.mapper.UserMapper.myDelete",211);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    // 删除数据
    public void myUpdate() throws IOException {
        String resource = "sqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        Actor actor = new Actor();
        actor.setActorId(new Long(212));
        actor.setFirstName("郑111");
        actor.setLastName("鹏飞111");
        // selectList查询多条记录
        int result =  sqlSession.update("cn.zpf.mapper.UserMapper.myUpdate",actor);
        sqlSession.commit();
        sqlSession.close();
    }

/*    @Test
    public void findUserById() throws Exception{
        ActorDao actorDao = new ActorDaoImpl(sqlSessionFactory);

        Actor actor = actorDao.findUserById(new Long(1));

        System.out.println(actor);
    }*/
}
