package com.revature.service;

import com.revature.pojo.Room;

public interface UpdateOosService {

	// maybe implement data validation here? 
	
	public void roomOutofService(Room room);
	
	public void roomInService(Room room);
	
}
