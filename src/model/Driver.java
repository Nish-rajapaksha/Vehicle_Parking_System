package model;

public class Driver {
    private String name;
    private String nic;
    private String  lNumber;
    private String address;
    private String phone_Number;

    public Driver() {
    }

    public Driver(String name, String nic, String lNumber, String address, String phone_Number) {
        this.name = name;
        this.nic = nic;
        this.lNumber = lNumber;
        this.address = address;
        this.phone_Number = phone_Number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getlNumber() {
        return lNumber;
    }

    public void setlNumber(String lNumber) {
        this.lNumber = lNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", lNumber='" + lNumber + '\'' +
                ", address='" + address + '\'' +
                ", phone_Number='" + phone_Number + '\'' +
                '}';
    }
}
