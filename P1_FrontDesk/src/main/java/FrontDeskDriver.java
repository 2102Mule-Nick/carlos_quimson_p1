import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.revature.config.AppConfig;
import com.revature.dao.RoomDaoJdbcTemplate;
import com.revature.messaging.JmsMessageSender;
import com.revature.pojo.Room;

public class FrontDeskDriver {

	public static void main(String[] args) {
		
		String command = null;
		
		Scanner scan = new Scanner(System.in);
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		
		JmsMessageSender messageSender = appContext.getBean("jmsMessageSender", JmsMessageSender.class);
		
		RoomDaoJdbcTemplate roomDao = appContext.getBean(RoomDaoJdbcTemplate.class);
		
		/***********************************************
		 * Testing using SOAP via the updateOos
		 */
		System.out.println("Attempting to Update OOS");
		Room room = new Room();
		room.setRoomNumber(101);
		room.setRoomOutOfService(false);
		
		roomDao.updateRoomOutOfService(room);
		System.out.println("Room out of Service updated");
	}
	
}
