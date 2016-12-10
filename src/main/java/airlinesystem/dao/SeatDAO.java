package airlinesystem.dao;

import java.util.List;

import airlinesystem.entity.Airplane;
import airlinesystem.entity.Seat;

public interface SeatDAO
{	
	public Seat find(long id);
	
	public List<Seat> findByAirplane(Airplane airplane);
	
	public Seat findBySeatNumber(String seatNumber);
}