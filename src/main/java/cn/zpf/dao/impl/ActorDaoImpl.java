package cn.zpf.dao.impl;

import cn.zpf.dao.ActorDao;
import cn.zpf.dto.Actor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by LoseMyself on 2017/3/9.
 */
public class ActorDaoImpl implements ActorDao {

    // 需要向dao实现类中注入SqlSessionFactory
    // 此处通过构造函数注入
    private SqlSessionFactory sqlSessionFactory;
    public ActorDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Actor findUserById(Long id) throws Exception {
        // 因为线程的不安全性,所以在方法体内使用
        // 调用SqlSession产生Session对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 将传入参数转化为泛型,但是编译时不会报错运行时才会报错.
        sqlSession.selectOne("cn.zpf.mapper.UserMapper.findActorById",id);
        return null;
    }



}
