import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;
import com.revature.dao.RoomDaoJdbcTemplate;
import com.revature.pojo.Room;

public class MaintenanceTestDriver {
	
	public static void main(String[] args) {
			
		System.out.println("Maintenance Test Application Driver starting up.....");
	
		String command = null;
			
		Scanner scan = new Scanner(System.in);
			
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//Testing updating isOccupied 
//		RoomDaoJdbcTemplate roomDao = appContext.getBean(RoomDaoJdbcTemplate.class);
//		
//		Room room = new Room();
//		
//		room.setRoomNumber(101);
//		room.setRoomOutOfService(true);
//		
//		roomDao.updateRoomOutOfService(room);
		
	
	
	}

}
