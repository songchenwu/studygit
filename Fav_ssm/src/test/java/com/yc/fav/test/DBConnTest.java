package com.yc.fav.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class DBConnTest {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConn() {
		System.out.println("加一句");
		System.out.println("再加一句");
		Connection con=null;
		con=sqlSessionFactory.openSession().getConnection();
		assertNotNull("数据库连接失败~",con);
	}

}
