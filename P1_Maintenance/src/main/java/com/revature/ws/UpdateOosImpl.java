package com.revature.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pojo.Room;
import com.revature.service.UpdateOosService;

@Service
public class UpdateOosImpl implements UpdateOos {

	private UpdateOosService updateOccupiedService;
	
	@Autowired
	public void setUpdateOccupiedService(UpdateOosService updateOccupiedService) {
		this.updateOccupiedService = updateOccupiedService;
	}

	@Override
	public void roomOutofService(Room room) {
		updateOccupiedService.roomOutofService(room);

	}

	@Override
	public void roomInService(Room room) {

		updateOccupiedService.roomInService(room);

	}

}
