package kr.ac.jejuuniv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class User {
	private String id;
	private String name;
	private String password;
	
	
//	@Autowired
//	private UserDao userDao;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
//	public User getUser() {
//		return userDao.get(this.id);
//	}

}
