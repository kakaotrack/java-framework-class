package kr.ac.jejuuniv;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

//@Component
public class SqlSessionFactoryBean implements FactoryBean<SqlSessionFactory> {

	@Override
	public SqlSessionFactory getObject() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Override
	public Class<?> getObjectType() {
		return SqlSessionFactory.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
