package model;

import java.util.List;

public class ParkingLot {
    private String lotId;
    private List<ParkingFloor> parkingFloors;

    public ParkingLot(String lotId, List<ParkingFloor> parkingFloors) {
        this.lotId = lotId;
        this.parkingFloors = parkingFloors;
    }

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
}
