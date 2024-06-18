package com.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entity.Room;

public interface RoomRepository  extends JpaRepository<Room, Long> {
	List<Room> findByAvailability(boolean availability);
}
