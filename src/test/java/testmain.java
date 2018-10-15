import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.MKBot.configuration.MKBotRootConfig;
import com.MKBot.dao.UserDao;
import com.MKBot.domain.User;

public class testmain {
	
	public static void main(String[] args) {
		
		
		ApplicationContext ctx= new AnnotationConfigApplicationContext(MKBotRootConfig.class);
		
		UserDao userDao=ctx.getBean(UserDao.class);
		User u=new User();
		u.setName("Sekhar");
		u.setAddress("Tenali");
		u.setEmail("chandrasekhar.melam1@live.com");
		u.setLoginName("sekhar1");
		u.setLoginStatus(1);
		u.setPassword("sekhar");
		u.setPhone("100");
		u.setRole(1);
	
		userDao.Save(u);
	}

}
