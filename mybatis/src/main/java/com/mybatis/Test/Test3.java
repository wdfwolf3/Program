package com.mybatis.Test;

import com.mybatis.bean.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wdfwolf3 on 2017/5/2.
 */
public class Test3 {
    public static void main(String[] args) throws IOException {
        //mybatis的配置文件
        String resource = "mybatisconfig.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sqlSessionFactory.openSession();
        String statement = "com.practice.xml.UsersMapper.getUser";
        Users user = session.selectOne(statement, "瓦房店");
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        session.close();
        System.out.println(user.getId());
    }
}
