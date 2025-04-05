package gate;

import model.Ticket;
import model.Vehicle;
import service.BillingSystem;
import service.ParkingSpotManager;
import service.TicketManager;

public class ExitGate {
    ParkingSpotManager parkingSpotManager;
    TicketManager ticketManager;

    public ExitGate(ParkingSpotManager parkingSpotManager, TicketManager ticketManager) {
        this.parkingSpotManager = parkingSpotManager;
        this.ticketManager = ticketManager;
    }

    public double processVehicleExit(String ticketId){
        Ticket ticket = ticketManager.getTicket(ticketId);
        if(ticket ==null){
            throw new RuntimeException("No such ticket" + ticketId);
        }
        double amount = BillingSystem.generateBilling(ticket);
        parkingSpotManager.releaseSpot(ticket.getParkingSpot());
        ticketManager.closeTicket(ticketId);

        return amount;
    }


}
