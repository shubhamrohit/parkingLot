package service;

import model.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class BillingSystem {
    public static double generateBilling(Ticket ticket){
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(ticket.getEntryTime(), now);
        double hours = Math.max(1,duration.toHours());
        return hours * 20;
    }
}
