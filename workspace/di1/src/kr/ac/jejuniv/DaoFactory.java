package kr.ac.jejuniv;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

	private DConnectionMaker connectionMaker;
	
	public DaoFactory() {
		this.setConnectionMaker(new DConnectionMaker());
	}

	@Bean
	public UserDao userDao() {
		return new UserDao(getConnectionMaker());
	}

	public DConnectionMaker getConnectionMaker() {
		return connectionMaker;
	}

	public void setConnectionMaker(DConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

}
