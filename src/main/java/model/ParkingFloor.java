package model;

import java.util.List;

public class ParkingFloor {
    private String floorId;
    private List<ParkingSpot> parkingSpots;

    public ParkingFloor(String floorId, List<ParkingSpot> parkingSpots) {
        this.floorId = floorId;
        this.parkingSpots = parkingSpots;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
