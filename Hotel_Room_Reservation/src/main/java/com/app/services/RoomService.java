package com.app.services;

import java.util.List;

import com.app.DTO.RoomDto;

public interface RoomService {

	RoomDto addRoom(RoomDto roomdto);
	RoomDto updateRoom(long id, RoomDto roomdto);
	List<RoomDto> getAvailable();
}
