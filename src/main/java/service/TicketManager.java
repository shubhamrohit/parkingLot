package service;

import enums.SpotType;
import model.ParkingSpot;
import model.Ticket;
import model.Vehicle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// generate and store ticket
// retrieve ticket for billing
public class TicketManager {
    private Map<String, Ticket> availableTickets = new HashMap<>();
    private int ticketCount = 1;

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot spot) {
        String ticketId = "Ticket - "+ ticketCount++;
        Ticket ticket = new Ticket(ticketId, LocalDateTime.now(), spot, vehicle);
        availableTickets.put(ticketId, ticket);
        return ticket;
    }
    public Ticket getTicket(String ticketId){
        return availableTickets.get(ticketId);
    }
    public void closeTicket(String ticketId){
        availableTickets.remove(ticketId);
    }

}
