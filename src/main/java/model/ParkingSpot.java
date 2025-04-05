package model;

import enums.SpotType;

public class ParkingSpot {
    private String spotId;
    private SpotType spotType;
    private Boolean isAvailable;
    private Vehicle parkedVechile;

    public ParkingSpot(String spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.parkedVechile = vehicle;
        this.isAvailable = true;
    }

    public void removeVehicle() {
        this.parkedVechile = null;
        this.isAvailable = false;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public Boolean getOccupied() {
        return isAvailable;
    }

    public void setOccupied(Boolean occupied) {
        isAvailable = occupied;
    }

    public Vehicle getParkedVechile() {
        return parkedVechile;
    }

    public void setParkedVechile(Vehicle parkedVechile) {
        this.parkedVechile = parkedVechile;
    }
}
