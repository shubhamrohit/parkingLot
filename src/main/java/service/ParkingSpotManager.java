package service;

// Keep track of available spot
// Allocate a spot
// free up a spot

import enums.SpotType;
import model.ParkingSpot;
import model.Vehicle;


import java.util.*;

public class ParkingSpotManager {
    Map<SpotType, Queue<ParkingSpot>> spotMap = new HashMap<>();

    public void addSpot(ParkingSpot spot) {
        Queue<ParkingSpot> spots = spotMap.get(spot.getSpotType());
        if (spots == null) {
            spots = new LinkedList<>();
            spotMap.put(spot.getSpotType(), spots);
        }
        spots.add(spot);
    }

    public ParkingSpot getAvailableSpot(Vehicle vehicle) {
        Queue<ParkingSpot> availableSpots = spotMap.get(SpotType.valueOf(vehicle.getVechileType().name()));
        if(availableSpots == null || availableSpots.isEmpty()){
            throw new RuntimeException( "No Available spot for " + vehicle.getVechileType().name());
        }
        ParkingSpot spot = availableSpots.poll();
        spot.parkVehicle(vehicle);
        return spot;
    }
    public void releaseSpot(ParkingSpot spot){
        spot.removeVehicle();
        spotMap.get(spot.getSpotType()).add(spot);

    }
}
