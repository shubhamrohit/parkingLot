package gate;

import model.ParkingSpot;
import model.Ticket;
import model.Vehicle;
import service.ParkingSpotManager;
import service.TicketManager;

public class EntryGate {
    private ParkingSpotManager parkingSpotManager;
    private TicketManager ticketManager;

    public Ticket processVehicleEntry(Vehicle vehicle){
        ParkingSpot spot = parkingSpotManager.getAvailableSpot(vehicle);
        return ticketManager.generateTicket(vehicle,spot);

    }

    public EntryGate(ParkingSpotManager parkingSpotManager, TicketManager ticketManager) {
        this.parkingSpotManager = parkingSpotManager;
        this.ticketManager = ticketManager;
    }
}
