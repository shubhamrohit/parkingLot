package model;

import enums.VehicleType;

public class Vehicle {
    private String vechileNumber;
    private VehicleType vechileType;

    public Vehicle(String vechileNumber, VehicleType vechileType) {
        this.vechileNumber = vechileNumber;
        this.vechileType = vechileType;
    }

    public String getVechileNumber() {
        return vechileNumber;
    }

    public void setVechileNumber(String vechileNumber) {
        this.vechileNumber = vechileNumber;
    }

    public VehicleType getVechileType() {
        return vechileType;
    }

    public void setVechileType(VehicleType vechileType) {
        this.vechileType = vechileType;
    }
}
