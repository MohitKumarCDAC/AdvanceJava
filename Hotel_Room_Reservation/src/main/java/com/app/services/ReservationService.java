package com.app.services;

import java.util.List;

import com.app.DTO.ReservationDto;
import com.app.DTO.ReservationFetchDto;

public interface ReservationService {
  List<ReservationFetchDto>getAllReservation();
  ReservationDto addReservation(ReservationDto reservationDto);
  ReservationFetchDto findReservationByID(Long id);
  ReservationDto cancleReservation(Long id);
}
