package com.item.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MySqlSession {
  private   static SqlSession sqlSession;
  private  static InputStream  inputStream;
    static {
          //           1.加载配置文件,获取输入流
      try {
            inputStream = Resources.getResourceAsStream("AccountMapper.xml");
          //            2.创建工厂
          SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
          SqlSessionFactory sessionFactory = builder.build(inputStream);
         //            3.创建SqlSession
          sqlSession = sessionFactory.openSession();
      } catch (IOException e) {
          e.printStackTrace();
      }


  }

// 返回代理对象
    public static <T> T getMapper(Class<T> var1) {
//        创建代理对象
        T mapper = sqlSession.getMapper(var1);
        return mapper;
    }
//返回sqlSession对象
    public static  SqlSession getSqlSession(){
      return  sqlSession;
    }
//  增删改用：提交事务
    public static void getCommint(){
      sqlSession.commit();
    }
//关闭sqlSession 与    inputStream
    public static void close(){
        if(sqlSession!=null){
            sqlSession.close();
        }
        if(inputStream!=null){
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
}
