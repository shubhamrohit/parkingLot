package com.shubham;

import enums.SpotType;
import enums.VehicleType;
import gate.EntryGate;
import gate.ExitGate;
import model.ParkingSpot;
import model.Ticket;
import model.Vehicle;
import service.ParkingSpotManager;
import service.TicketManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(" Welcome to Parking Lot !!");

        ParkingSpotManager parkingSpotManager = new ParkingSpotManager();
        TicketManager ticketManager = new TicketManager();
        EntryGate entryGate = new EntryGate(parkingSpotManager, ticketManager);
        ExitGate exitGate = new ExitGate(parkingSpotManager, ticketManager);

        parkingSpotManager.addSpot(new ParkingSpot("C1", SpotType.CAR));
        parkingSpotManager.addSpot(new ParkingSpot("B1", SpotType.BIKE));

        // -------- CASE 1: Normal CAR Entry/Exit --------
        Vehicle car1 = new Vehicle("KA01AA1111", VehicleType.CAR);
        Ticket ticket1 = entryGate.processVehicleEntry(car1);
        System.out.println("Ticket Issued: " + ticket1.getTicketId());

        Thread.sleep(1000); // Simulate time
        double bill1 = exitGate.processVehicleExit(ticket1.getTicketId());
        System.out.println("Bill for car1: ₹" + bill1);

        System.out.println("---------------------------------------------------");

        // -------- CASE 2: BIKE Entry/Exit --------
        Vehicle bike1 = new Vehicle("KA02BB2222", VehicleType.BIKE);
        Ticket ticket2 = entryGate.processVehicleEntry(bike1);
        System.out.println("Ticket Issued: " + ticket2.getTicketId());

        Thread.sleep(2000);
        double bill2 = exitGate.processVehicleExit(ticket2.getTicketId());
        System.out.println("Bill for bike1: ₹" + bill2);

        System.out.println("---------------------------------------------------");

        // -------- CASE 3: No Spot Available (Car) --------
        try {
            Vehicle car2 = new Vehicle("KA03CC3333", VehicleType.CAR);
            entryGate.processVehicleEntry(car2); // only 1 spot was available and it's already used
        } catch (Exception e) {
            System.out.println("Expected Exception: " + e.getMessage());
        }

        System.out.println("---------------------------------------------------");

        // -------- CASE 4: Multiple Entries and Exits --------
        parkingSpotManager.addSpot(new ParkingSpot("C2", SpotType.CAR));
        parkingSpotManager.addSpot(new ParkingSpot("C3", SpotType.CAR));

        Vehicle car3 = new Vehicle("KA04DD4444", VehicleType.CAR);
        Vehicle car4 = new Vehicle("KA05EE5555", VehicleType.CAR);

        Ticket ticket3 = entryGate.processVehicleEntry(car3);
        Ticket ticket4 = entryGate.processVehicleEntry(car4);

        System.out.println("Car3 Ticket: " + ticket3.getTicketId());
        System.out.println("Car4 Ticket: " + ticket4.getTicketId());

        Thread.sleep(1000);
        double bill3 = exitGate.processVehicleExit(ticket3.getTicketId());
        double bill4 = exitGate.processVehicleExit(ticket4.getTicketId());

        System.out.println("Bill for car3: ₹" + bill3);
        System.out.println("Bill for car4: ₹" + bill4);

        System.out.println("---------------------------------------------------");

        // -------- CASE 5: Invalid Ticket ID (Exit without Entry) --------
        try {
            double invalidBill = exitGate.processVehicleExit("INVALID-TICKET");
        } catch (Exception e) {
            System.out.println("Expected Exception for invalid ticket: " + e.getMessage());
        }
    }
}