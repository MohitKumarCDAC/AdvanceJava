package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.RoomDto;
import com.app.Entity.Room;
import com.app.ExceptionHandler.RoomNotAvailableException;
import com.app.Repository.RoomRepository;

@Service
@Transactional
public class RoomServiceImpl  implements RoomService{

	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private ModelMapper mapper;


	@Override
	public RoomDto addRoom(RoomDto roomdto) {
		Room room=mapper.map(roomdto, Room.class);
		Room r=roomRepository.save(room);
		return mapper.map(r, RoomDto.class);
	}

	@Override
	public RoomDto updateRoom(long id, RoomDto roomdto) {
		String msg="error.......";
		Room room=mapper.map(roomdto, Room.class);
		if(roomRepository.existsById(id))
		{
			room.setRoomId(id);
			roomRepository.save(room);
			msg="Room Updated.....";
			return mapper.map(room, RoomDto.class);
		}
		throw new RoomNotAvailableException(msg);
	}

	@Override
	public List<RoomDto> getAvailable() {
		  List<RoomDto> list=roomRepository.findAll().stream()
				  .filter(i->i.isAvailability()).map(entiry->mapper.map(entiry, RoomDto.class)).collect(Collectors.toList());
																
		return list;
	}

	
	
	
	
}
