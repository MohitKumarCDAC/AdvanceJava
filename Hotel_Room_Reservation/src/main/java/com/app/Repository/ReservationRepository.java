package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	 
}
