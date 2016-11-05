package airlinesystem.model.operations;

import airlinesystem.model.entity.airline.Route;
import airlinesystem.model.entity.airline.Ticket;
import airlinesystem.model.entity.seat.Seat;
import java.util.List;

public interface GeneralOperations {
    public boolean checkLogin(String username, String senha);
    public void viewAvailableRoutes(List<Route> routes);
    public double getPriceTicket(Ticket ticket);
    public Ticket getTicketByNumber(int number);
    public List<Seat> getAvailableSeats(Route route);
}
