import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;

public class HousekeepingDriver {

	public static void main(String[] args) {
		
		System.out.println("Housekeeping Application starting up.....");
		
		String command = null;
		
		Scanner scan = new Scanner(System.in);
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		while(!"exit".equals(command)) {
			//just listening for messages
			command = scan.nextLine();
		}
		
	}
	
}