package junit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jar.domain.User;
import com.jar.service.UserService;

public class testUser {

//	UserService userService;
	@Test
	public void testSave() throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)ctx.getBean("userService"); 
		
//		UserDAO userDAO = (UserDAO)ctx.getBean("userDAO");
//		userService.setUserDAO(userDAO);
		userService.addUser(new User(4,"acasd@qq.com","heaheh","123451",1111111,0,"20110", 20131212,"112.110.101.1"));
	}
	
	
	@Test
	public void testSave2() throws Exception{

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)ctx.getBean("userService"); 
	
	
//		User user = new User("12311@qq.com", "aaa", "111111");
		
//		userService.addUser(user);
		
	}
	
	
	
	@Test
	public void testSql(){
		User user = new User(1,"asd@qq.com","haha","123",1111,1,"2010", 20121212,"110.110.101.1");
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
	
	@Test
	public void testFindByEmail() throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)ctx.getBean("userService"); 

		User user = userService.findByEmail("asd@qq.com");
		System.out.println(user.getNickname());
	}
	
	@Test
	public void testLogin() throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)ctx.getBean("userService"); 

		User user = userService.login("fgfgf@qq.com", "111111");
		System.out.println(user.getNickname());
	}
}
 