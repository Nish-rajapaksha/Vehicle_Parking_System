package model;

public class Slot {
    private String slotNumber;
    private String slotVehicleType;
    private String slotStatus;

    public Slot() {
    }

    public Slot(String slotNumber, String slotVehicleType, String slotStatus) {
        this.slotNumber = slotNumber;
        this.slotVehicleType = slotVehicleType;
        this.slotStatus = slotStatus;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getSlotVehicleType() {
        return slotVehicleType;
    }

    public void setSlotVehicleType(String slotVehicleType) {
        this.slotVehicleType = slotVehicleType;
    }

    public String getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(String slotStatus) {
        this.slotStatus = slotStatus;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotNumber='" + slotNumber + '\'' +
                ", slotVehicleType='" + slotVehicleType + '\'' +
                ", slotStatus='" + slotStatus + '\'' +
                '}';
    }
}
