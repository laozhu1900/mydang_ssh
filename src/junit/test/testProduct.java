package junit.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jar.domain.Book;
import com.jar.domain.Product;
import com.jar.service.ProductService;
import com.jar.service.UserService;
import com.jar.util.PageBean;

public class testProduct {

//	@Test
//	public void testGetAll(){
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
////		UserService userService = (UserService)ctx.getBean("userService"); 
//		
//		ProductService productService = (ProductService) ctx.getBean("productService");
//		
//		List<Product> list = productService.getAll();
//		
//		for(Product p:list){
//			System.out.println(p.getProductPic());
//		}
//		
//	}
//	
//	@Test
//	public void testGetTotalRecord(){
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
////		UserService userService = (UserService)ctx.getBean("userService"); 
//		
//		ProductService productService = (ProductService) ctx.getBean("productService");
//		
//		System.out.println(productService.getTotalRecord());
//		
//	}
	
	@Test
	public void testGetAllByPage(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		UserService userService = (UserService)ctx.getBean("userService"); 
		
		ProductService productService = (ProductService) ctx.getBean("productService");
		
		PageBean bean = productService.queryForPage(6, 1);
		
		for(Book b:bean.getList()){
			System.out.println(b.getAuthor());
		}
		
	}
}
