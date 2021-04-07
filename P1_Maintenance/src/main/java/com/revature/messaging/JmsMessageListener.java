package com.revature.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.revature.config.AppConfig;
import com.revature.dao.RoomDao;
import com.revature.pojo.Room;

@Component
public class JmsMessageListener implements MessageListener {

	private RoomDao roomDao;
		
	@Autowired
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@JmsListener(destination = AppConfig.ROOM_OOS_QUEUE)
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		
		if (message instanceof ObjectMessage) {

			ObjectMessage om = (ObjectMessage) message;

			try {
				Room room = (Room) om.getObject();
				roomDao.updateRoomOutOfService(room); // CALL SERVICE INSTEAD
				System.out.println("Message Received: Updating room");

			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
