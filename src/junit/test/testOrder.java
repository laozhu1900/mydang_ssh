package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jar.domain.Order;
import com.jar.domain.ReceiveAddr;
import com.jar.service.OrderService;

public class testOrder {

	
	@Test
	public void testSaveAddr(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService orderService =  (OrderService) ctx.getBean("orderService"); 
			
		
		orderService.addReceiveAddr(new ReceiveAddr(1, 1, "1", "1", "1", "1", "1", 0));
	
	
	}
	
	@Test
	public void testSaveOrder(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService orderService =  (OrderService) ctx.getBean("orderService"); 
			
		Order order = new Order(1, 1, "asd", 6, 8, 1, 1, 1, 1);
		order.setReceiveName("hah");
		order.setFullAddress("asd");
		order.setPostalCode("1");
		order.setMobile("1");
		order.setPhone("1");
		order.setUserId(1);
		
		orderService.addReceiveAddr(order);
	
	
	}
	
}
