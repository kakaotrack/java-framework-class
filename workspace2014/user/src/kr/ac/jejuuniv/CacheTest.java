package kr.ac.jejuuniv;

import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")
public class CacheTest {
	@Autowired
	private UserService userService;

	@Test
	public void getTest() {
		User user = userService.get("1");
		System.out.println(user.getName());
		userService.get("1");
	}
}
