package com.revature.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.revature.pojo.Room;

@WebService
public interface UpdateOos {
	
	@WebMethod
	public void roomOutofService(Room room);
	
	@WebMethod
	public void roomInService(Room room);

}
