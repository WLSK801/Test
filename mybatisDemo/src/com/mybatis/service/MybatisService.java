package com.mybatis.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.entity.User;

/**
 * @ClassName: MybatisService
 * @Description: TODO(mybatis���ų���)
 * @author warcaft
 * @date 2015-6-27 ����4:49:49
 * 
 */
public class MybatisService {
    // ����Id��ѯ�û���Ϣ���õ�һ����¼���
    @Test
    public void findUserByIdTest() {
        // mybatis�������ļ�
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            // 1.�����Ự����,����mybatis�������ļ���Ϣ
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(inputStream);

            // 2.ͨ�������õ�SqlSession
            sqlSession = sqlSessionFactory.openSession();

            // 3.ͨ��sqlSession�������ݿ�
            // ��һ��������ӳ���ļ��е�statement��Id,����namespace + "." + statement��id;
            // �ڶ�������:ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���;
            // sqlSession.selectOne�������ӳ���ļ���ƥ���resultType���͵Ķ���;
            // selectOne����ѯһ�����
            User user = sqlSession.selectOne("test.findUserById", 1);
            System.out.println(user.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // ��������ģ����ѯ�û���Ϣ���õ�һ���������¼���
    @Test
    public void findUserByNameTest() {
        // mybatis�������ļ�
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            // 1.�����Ự����,����mybatis�������ļ���Ϣ
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(inputStream);

            // 2.ͨ�������õ�SqlSession
            sqlSession = sqlSessionFactory.openSession();

            // 3.ͨ��sqlSession�������ݿ�
            // ��һ��������ӳ���ļ��е�statement��Id,����namespace + "." + statement��id;
            // �ڶ�������:ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���;
            // sqlSession.selectOne�������ӳ���ļ���ƥ���resultType���͵Ķ���;
            // list�е�user��resultType����һ��
            List<User> list = sqlSession.selectList("test.findUserByName", "С");
            System.out.println(list);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // ����û�
    @Test
    public void insertUserTest() {
        // mybatis�������ļ�
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            // 1.�����Ự����,����mybatis�������ļ���Ϣ
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(inputStream);
            // 2.ͨ�������õ�SqlSession
            sqlSession = sqlSessionFactory.openSession();
            //�����û��Ķ���
            User user = new User();
            user.setUsername("С��");
            user.setBirthday(new Date());
            user.setSex("1");
            user.setAddress("�Ϻ�");
            // 3.ͨ��sqlSession�������ݿ�
            // ��һ��������ӳ���ļ��е�statement��Id,����namespace + "." + statement��id;
            // �ڶ�������:ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���;
            // sqlSession.selectOne�������ӳ���ļ���ƥ���resultType���͵Ķ���;
            sqlSession.insert("test.insertUser", user);
            //ִ���ύ����
            sqlSession.commit();
            
            //��Ŀ�о�����Ҫ ��ȡ�������û�������
            System.out.println(user.getId());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // ����Idɾ���û�
        @Test
        public void deleteUserTest() {
            // mybatis�������ļ�
            String resource = "SqlMapConfig.xml";
            InputStream inputStream = null;
            SqlSession sqlSession = null;
            try {
                inputStream = Resources.getResourceAsStream(resource);
                // 1.�����Ự����,����mybatis�������ļ���Ϣ
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                        .build(inputStream);
                // 2.ͨ�������õ�SqlSession
                sqlSession = sqlSessionFactory.openSession();
                // 3.ͨ��sqlSession�������ݿ�
                // ��һ��������ӳ���ļ��е�statement��Id,����namespace + "." + statement��id;
                // �ڶ�������:ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���;
                // sqlSession.selectOne�������ӳ���ļ���ƥ���resultType���͵Ķ���;
                //����Id��ɾ���û�
                sqlSession.delete("test.deleteUser", 7);
                //ִ���ύ����
                sqlSession.commit();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (sqlSession != null) {
                    sqlSession.close();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
        // ����Id�����û���Ϣ
        @Test
        public void updateUserTest() {
            // mybatis�������ļ�
            String resource = "SqlMapConfig.xml";
            InputStream inputStream = null;
            SqlSession sqlSession = null;
            try {
                inputStream = Resources.getResourceAsStream(resource);
                // 1.�����Ự����,����mybatis�������ļ���Ϣ
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                        .build(inputStream);
                // 2.ͨ�������õ�SqlSession
                sqlSession = sqlSessionFactory.openSession();
                //�����û�����Ϣ
                User user = new User();
                user.setId(2);
                user.setUsername("С��");
                user.setBirthday(new Date());
                user.setSex("2");
                user.setAddress("�Ϻ�");
                // 3.ͨ��sqlSession�������ݿ�
                // ��һ��������ӳ���ļ��е�statement��Id,����namespace + "." + statement��id;
                // �ڶ�������:ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���;
                // sqlSession.selectOne�������ӳ���ļ���ƥ���resultType���͵Ķ���;
                //����Id�����û�
                sqlSession.update("test.updateUser", user);
                //ִ���ύ����
                sqlSession.commit();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (sqlSession != null) {
                    sqlSession.close();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}