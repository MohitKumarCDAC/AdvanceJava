package com.app.services;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.ReservationDto;
import com.app.DTO.ReservationFetchDto;
import com.app.DTO.RoomDto;
import com.app.Entity.Reservation;
import com.app.Entity.Room;
import com.app.ExceptionHandler.ReservationNotFoundException;
import com.app.Repository.ReservationRepository;
import com.app.Repository.RoomRepository;
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	
	
	
	
	@Override
	public List<ReservationFetchDto> getAllReservation() {
		return reservationRepository.findAll().stream()
		.map(reservation->{ReservationFetchDto fetchDto = mapper.map(reservation, ReservationFetchDto.class);
        // Manually set the roomId in the DTO
        if (reservation.getRoom() != null) {
            fetchDto.setRoomId(reservation.getRoom().getRoomId());
        }
        fetchDto.setTotalPrice(reservation.getTotalPrice());
        return fetchDto;}).collect(Collectors.toList());
		
	}

	@Override
	public ReservationDto addReservation(ReservationDto reservationDto) {
		
		//convert dto to entity
		Reservation reservation=mapper.map(reservationDto, Reservation.class);
		// Save reservation to database (assuming you have a ReservationRepository)
        // reservation = reservationRepository.save(reservation);
		Room room = roomRepository.findById(reservationDto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));
		
		 if (!room.isAvailability()) {
	            throw new RuntimeException("Room with id " + room.getRoomId() + " is already booked.");
	        }
		
		
		room.setAvailability(false);
        reservation.setRoom(room);
        
        
        long daysBetween = ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate());
        double pricePerDay = room.getPrice(); 
        double totalPrice = daysBetween * pricePerDay;
        reservation.setTotalPrice(totalPrice);
        
        
        
		reservation=reservationRepository.save(reservation);
		ReservationDto resultDto = mapper.map(reservation, ReservationDto.class);
        // Manually set the roomId in the DTO
        resultDto.setRoomId(reservation.getRoom().getRoomId());

        return resultDto;	
        }

	@Override
	public ReservationFetchDto findReservationByID(Long id) {
		Reservation reservation=reservationRepository.findById(id).
				orElseThrow(()->new ReservationNotFoundException("id not found ....."));
		
		 ReservationFetchDto fetchDto = mapper.map(reservation, ReservationFetchDto.class);
		    
		    // Manually set the roomId in the DTO
		    if (reservation.getRoom() != null) {
		        fetchDto.setRoomId(reservation.getRoom().getRoomId());
		    }
		    
		    fetchDto.setTotalPrice(reservation.getTotalPrice());
		    
		    return fetchDto;
	}

	@Override
	public ReservationDto cancleReservation(Long id) {
		Reservation reservation=reservationRepository.findById(id)
				.orElseThrow(()->new ReservationNotFoundException("Id Mismatch.."));
		//delete reservation
		reservationRepository.deleteById(id);
		//and then set room avavility is true
		Room room=reservation.getRoom();
		room.setAvailability(true);
		//and the save into db
		roomRepository.save(room);
		//and the map the vlaue
		return mapper.map(room, ReservationDto.class);
	}

}
